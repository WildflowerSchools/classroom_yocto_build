SUMMARY = "Python driver for Raspberry Pi Camera"
HOMEPAGE = "https://pypi.python.org/pypi/picamera"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a5f6282f39d52726bdc1e51d5c4b95c9"

RDEPENDS_${PN} += " \
    python3-numpy \
    python3-image \
    python3-multiprocessing \
    python3-netclient \
    userland \
    "

SRC_URI[md5sum] = "47e815b0f21bba2a91ab3c4cd36c6f90"
SRC_URI[sha256sum] = "890815aa01e4d855a6a95dd3ad0953b872a6b954982106407df0c5a31a163e50"

inherit pypi setuptools3

distutils3_do_install_prepend() {
    # This is necessary because picamera setup.py checks /proc/cpuinfo for
    # Raspberry Pi to make sure you don't use it on a non-Pi machine. Setting
    # READTHEDOCS=True prevents that check.
    export READTHEDOCS=True
}

PYPI_PACKAGE = "picamera"
