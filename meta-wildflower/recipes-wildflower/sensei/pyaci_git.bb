# Copyright (C) 2018 The Wildflower Foundation
# Released under the MIT license (see COPYING.MIT for the terms)
FILESEXTRAPATHS_append := "${TOPDIR}/../poky/meta"

DESCRIPTION = "Sensor Data Capture and Upload"
HOMEPAGE = ""
LICENSE = "MIT"
RDEPENDS_${PN}-collector = " \
    python3-argparse \
    python3-datetime \
    python3-json \
    python3-logging \
    python3-threading \
\
    python3-pyserial \
    python3-pyyaml \
    python3-redis \
    python3-tzlocal \
    redis \
    sensei-client \
    ${PN}-common \
    "

RDEPENDS_${PN}-uploader = " \
    python3-argparse \
    python3-datetime \
    python3-json \
    python3-lang \
\
    python3-redis \
    redis \
    sensei-client \
    ${PN}-common \
    "

inherit systemd

PACKAGES="${PN}-common ${PN}-collector ${PN}-uploader"
SYSTEMD_PACKAGES="${PN}-collector ${PN}-uploader"

SRCREV = "2c204939aef0c5be2ecf2c91c455c45bb9fd002a"
SRC_URI = " \
    git://github.com/WildflowerSchools/sensei_mesh;protocol=http \
    file://COPYING.MIT \
    file://pyaci-collector.service \
    file://pyaci-uploader.service \
    file://serial.rules \
    "

S = "${WORKDIR}/git/pyaci"

do_install() {
    install         -d                     ${D}/opt/wildflower/pyaci/aci
    install -m 0644 ${S}/aci/AciCommand.py ${D}/opt/wildflower/pyaci/aci
    install -m 0644 ${S}/aci/AciEvent.py   ${D}/opt/wildflower/pyaci/aci
    install -m 0644 ${S}/aci/__init__.py   ${D}/opt/wildflower/pyaci/aci

    install         -d                          ${D}/opt/wildflower/pyaci/aci_serial
    install -m 0644 ${S}/aci_serial/AciUart.py  ${D}/opt/wildflower/pyaci/aci_serial
    install -m 0644 ${S}/aci_serial/__init__.py ${D}/opt/wildflower/pyaci/aci_serial

    install -m 0644 ${S}/datetime_modulo.py ${D}/opt/wildflower/pyaci
    install -m 0644 ${S}/sensei_cmd.py      ${D}/opt/wildflower/pyaci
    install -m 0755 ${S}/collector.py       ${D}/opt/wildflower/pyaci
    install -m 0755 ${S}/uploader.py       ${D}/opt/wildflower/pyaci

    install         -d                       ${D}${ROOT_HOME}
    install -m 0644 ${S}/example_sensei.yaml ${D}${ROOT_HOME}/.sensei.yaml

    install         -d                                 ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/pyaci-collector.service ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/pyaci-uploader.service  ${D}${systemd_unitdir}/system

    install         -d                      ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/serial.rules ${D}${sysconfdir}/udev/rules.d
}

FILES_${PN}-common = " \
    /opt/wildflower/pyaci/sensei_cmd.py \
    ${CONFFILES_${PN}-common} \
    "
CONFFILES_${PN}-common = " \
    ${ROOT_HOME}/.sensei.yaml \
    "

FILES_${PN}-collector = " \
    /opt/wildflower/pyaci/aci \
    /opt/wildflower/pyaci/aci_serial \
    /opt/wildflower/pyaci/datetime_modulo.py \
    /opt/wildflower/pyaci/collector.py \
    ${sysconfdir}/udev/rules.d/serial.rules \
    "
SYSTEMD_SERVICE_${PN}-collector = "${PN}-collector.service"

FILES_${PN}-uploader = " \
    /opt/wildflower/pyaci/uploader.py \
    "
SYSTEMD_SERVICE_${PN}-uploader = "${PN}-uploader.service"

LIC_FILES_CHKSUM = "file://../../COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
