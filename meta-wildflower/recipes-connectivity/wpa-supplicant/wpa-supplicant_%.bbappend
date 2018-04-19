FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
            file://wpa_supplicant.conf \
            "

# Working around a bug in the poky-rocko provided systemctl
#FILES_${PN} += "${systemd_unitdir}/system"
#SYSTEMD_SERVICE_${PN} = "wpa_supplicant@wlan0.service"
#SYSTEMD_AUTO_ENABLE = "enable"

do_install_append() {
    install         -d                             ${D}/config
    install -m 0644 ${WORKDIR}/wpa_supplicant.conf ${D}/config

    install -d                                     ${D}${sysconfdir}/wpa_supplicant
    ln      -sf /boot/config/wpa_supplicant.conf   ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf

# Working around a bug in the poky-rocko provided systemctl
    install -d                                                    ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
    ln      -sf ${systemd_unitdir}/system/wpa_supplicant@.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/wpa_supplicant@wlan0.service
}

FILES_${PN} += "/config/wpa_supplicant.conf ${sysconfdir}/wpa_supplicant"
# Working around a bug in the poky-rocko provided systemctl
FILES_${PN} += "${sysconfdir}/systemd/system/multi-user.target.wants/wpa_supplicant@wlan0.service"
