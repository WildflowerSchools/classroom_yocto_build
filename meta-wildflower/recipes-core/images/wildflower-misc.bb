SUMMARY = "Misc files needed by Wildflower image"
HOMEPAGE = "https://github.com/WildflowerSchools/"
LICENSE = "MIT"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
            file://settings.txt \
            file://hostname.service \
            file://COPYING \
            "
LIC_FILES_CHKSUM = "file://../COPYING;md5=0835ade698e0bcf8506ecda2f7b4f302"

do_install() {
    install         -d                             ${D}/config
    install -m 0644 ${WORKDIR}/settings.txt        ${D}/config
    install         -d                          ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/hostname.service ${D}${systemd_unitdir}/system
    install -d                                             ${D}${sysconfdir}/systemd/system/local-fs.target.wants/
    ln      -sf ${systemd_unitdir}/system/hostname.service ${D}${sysconfdir}/systemd/system/local-fs.target.wants/
}

FILES_${PN} = "/config /etc /lib/systemd"
