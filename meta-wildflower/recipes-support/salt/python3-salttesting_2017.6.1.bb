SUMMARY = "Common testing tools used in the Salt Stack projects"
HOMEPAGE = "https://github.com/saltstack/salt-testing"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f36f1e9e3e30f90180efdf7e40d943e5"
SRCNAME = "salt-testing"

FILESEXTRAPATHS_append := "${THISDIR}/${PN}"

SRC_URI = "https://github.com/saltstack/salt-testing/archive/v${PV}.tar.gz;downloadfilename=salt-testing-v${PV}.tar.gz \
           "
#           file://0001-Add-ptest-output-option-to-test-suite.patch
SRC_URI[md5sum] = "3bb3f86365f2892683d17f36fcc51c4c"
SRC_URI[sha256sum] = "445bde85f6f7664bfcd93a18b8b5bb39e43b594afa95e2ea5d5cc297a9d47b91"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} = "\
                  python-mock \
                  python-unittest \
"

inherit setuptools3

