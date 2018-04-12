SUMMARY = "Misc files needed by Wildflower image"
HOMEPAGE = "https://github.com/WildflowerSchools/"
LICENSE = "MIT"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
            file://25-wireless.network \
            file://wpa_supplicant.conf \
            file://settings.txt \
            file://hostname.service \
            file://COPYING \
            "
LIC_FILES_CHKSUM = "file://../COPYING;md5=0835ade698e0bcf8506ecda2f7b4f302"

do_install() {
    install         -d                             ${D}/config
    install -m 0644 ${WORKDIR}/settings.txt        ${D}/config
    install -m 0644 ${WORKDIR}/wpa_supplicant.conf ${D}/config

    install         -d                          ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/hostname.service ${D}${systemd_unitdir}/system
    install -d                                             ${D}${sysconfdir}/systemd/system/local-fs.target.wants/
    ln      -sf ${systemd_unitdir}/system/hostname.service ${D}${sysconfdir}/systemd/system/local-fs.target.wants/

    install -d                                     ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/25-wireless.network ${D}${sysconfdir}/systemd/network/
    install -d                                     ${D}${sysconfdir}/wpa_supplicant
    ln      -sf /boot/config/wpa_supplicant.conf   ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf
    install -d                                                    ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
    ln      -sf ${systemd_unitdir}/system/wpa_supplicant@.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/wpa_supplicant@wlan0.service
}

FILES_${PN} = "/config /etc /lib/systemd"
