# Copyright (C) 2018 Alex Austin <Circuitsoft.alex@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)
FILESEXTRAPATHS_append := "${TOPDIR}/../poky/meta"

PR="r0"

DESCRIPTION = "Wildflower Camera Capture and Upload"
HOMEPAGE = ""
LICENSE = "MIT"
RDEPENDS_${PN}-capture = " \
    python3-picamera \
\
    pyaci-common \
    "

RDEPENDS_${PN}-upload = " \
    ${PN}-capture \
    python3-boto3 \
    "

inherit systemd

PACKAGES="${PN}-capture ${PN}-upload"
SYSTEMD_PACKAGES="${PN}-capture ${PN}-upload"

SRCREV = "42eed234bdaf202b7594b25ebeaf53ac0e2be496"
SRC_URI = " \
    git://github.com/WildflowerSchools/camera;protocol=http \
    file://COPYING.MIT \
    file://sensei-camera-capture.service \
    file://sensei-camera-upload.service \
    "
S = "${WORKDIR}/git"

do_install() {
    install         -d              ${D}/opt/wildflower/camera
    install -m 0755 ${S}/capture.py ${D}/opt/wildflower/camera
    install -m 0755 ${S}/upload.py  ${D}/opt/wildflower/camera
    ln      -sf ../pyaci/senseiconf ${D}/opt/wildflower/camera

    install         -d                                       ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/sensei-camera-capture.service ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/sensei-camera-upload.service  ${D}${systemd_unitdir}/system

    install         -d ${D}/var/spool/wf-images
}

FILES_${PN}-capture = " \
    /opt/wildflower/camera/capture.py \
    /opt/wildflower/camera/senseiconf \
    /var/spool/wf-images \
    "
SYSTEMD_SERVICE_${PN}-capture = "${PN}-capture.service"

FILES_${PN}-upload = " \
    /opt/wildflower/camera/upload.py \
    "
SYSTEMD_SERVICE_${PN}-upload = "${PN}-upload.service"

LIC_FILES_CHKSUM = "file://../COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
