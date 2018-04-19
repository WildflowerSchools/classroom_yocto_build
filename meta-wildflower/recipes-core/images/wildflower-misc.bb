SUMMARY = "Misc files needed by Wildflower image"
HOMEPAGE = "https://github.com/WildflowerSchools/"
LICENSE = "MIT"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
            file://20-wired.network \
            file://25-wireless.network \
            file://settings.txt \
            file://hostname.service \
            file://COPYING \
            "
LIC_FILES_CHKSUM = "file://../COPYING;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

SYSTEMD_PACKAGES = "${PN}-hostname"
PACKAGES = "${PN}-hostname ${PN}-net"

do_install() {
    install         -d                             ${D}/config
    install -m 0644 ${WORKDIR}/settings.txt        ${D}/config

    install         -d                          ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/hostname.service ${D}${systemd_unitdir}/system

    install -d                                     ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/20-wired.network    ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/25-wireless.network ${D}${sysconfdir}/systemd/network/
}

SYSTEMD_SERVICE_${PN}-hostname = "hostname.service"

RDEPENDS_${PN}-net = "wpa-supplicant"

FILES_${PN}-hostname = "/config/settings.txt ${systemd_unitdir}/system/hostname.service"
FILES_${PN}-net = "${sysconfdir}/systemd/network"
