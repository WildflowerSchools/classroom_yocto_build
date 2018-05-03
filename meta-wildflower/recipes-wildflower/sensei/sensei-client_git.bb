# Copyright (C) 2018 Alex Austin <Circuitsoft.alex@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Wildflower Sensei client Python library"
HOMEPAGE = ""
LICENSE = "MIT"
DEPENDS = "python3-netclient python3-json python3-datetime python3-enum python3-dateutil"

inherit setuptools3

SRCREV = "ce942cf589db9b017ccbe5bd383b80cfbc180057"
SRC_URI = "git://github.com/WildflowerSchools/sensei_client;protocol=http"
S = "${WORKDIR}/git"


LIC_FILES_CHKSUM = "file://setup.py;beginline=43;endline=43;md5=0754c663425c81a845272675d7f7dbdb"
