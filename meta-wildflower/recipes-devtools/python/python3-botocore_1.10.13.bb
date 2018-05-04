SUMMARY = "The AWS SDK for Python"
HOMEPAGE = "https://pypi.python.org/pypi/botocore"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=71a3e14f29ac5c23e1b5b934ca4ddfc9"

SRC_URI[md5sum] = "81c699297f6d9bfeeffc9db16443c8c0"
SRC_URI[sha256sum] = "dd354517354a2698a2549a2c50196f81ca0730655177bf9628e8de00ce1b792a"

inherit pypi setuptools3

PYPI_PACKAGE = "botocore"

RDEPENDS_${PN} += " \
    python3-email \
    python3-json \
    python3-netserver \
    python3-numbers \
    python3-shell \
    python3-subprocess \
    python3-unixadmin \
    python3-xml \
\
    python3-dateutil \
    python3-jmespath \
    python3-pyopenssl \
"
