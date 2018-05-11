# Copyright (C) 2018 Alex Austin <Circuitsoft.alex@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "MP4Box from GPAC project"
HOMEPAGE = "https://github.com/gpac/gpac/tree/v0.7.1"
LICENSE = "LGPL-2.1"
SECTION = "multimedia"
DEPENDS = ""

PR="r0"

SRC_URI = " \
    git://github.com/gpac/gpac;protocol=http;tag=v${PV} \
    file://fix_cross.patch \
    "

inherit pkgconfig

do_configure() {
    ./configure --static-mp4box --use-zlib=no --cross-prefix=${TARGET_PREFIX}
}

do_install() {
    install         -d                  ${D}${bindir}
    install -m 0755 ${S}/bin/gcc/MP4Box ${D}${bindir}
}

FILES_${PN} = "${bindir}"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM = "file://COPYING;md5=dcf3c825659e82539645da41a7908589"
