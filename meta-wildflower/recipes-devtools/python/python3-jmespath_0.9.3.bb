SUMMARY = "JSON Matchin Expressions"
HOMEPAGE = "https://pypi.python.org/pypi/jmespath"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2683790f5fabb41a3f75b70558799eb4"

SRC_URI[md5sum] = "37a906c06de62bed25ec5cf99cee04a6"
SRC_URI[sha256sum] = "6a81d4c9aa62caf061cb517b4d9ad1dd300374cd4706997aff9cd6aedd61fc64"

inherit pypi setuptools3

PYPI_PACKAGE = "jmespath"

RDEPENDS_${PN} += " \
    python3-json \
    python3-stringold \
"
