SUMMARY = "Tzinfo object for the local timezone"
HOMEPAGE = "https://pypi.python.org/pypi/tzlocal"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=57e0bd61643d81d05683cdce65b11d10"

SRC_URI[md5sum] = "4553be891efa0812c4adfb0c6e818eec"
SRC_URI[sha256sum] = "4ebeb848845ac898da6519b9b31879cf13b6626f7184c496037b818e238f2c4e"

inherit pypi setuptools3

PYPI_PACKAGE = "tzlocal"

RDEPENDS_${PN} += "python3-pytz"
