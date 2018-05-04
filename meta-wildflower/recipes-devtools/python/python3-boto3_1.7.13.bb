SUMMARY = "The AWS SDK for Python"
HOMEPAGE = "https://pypi.python.org/pypi/boto3"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f6a383d75f587bd595dbc18cae94bcdb"

SRC_URI[md5sum] = "9c4089bed117a2f833b0dff0ac51c8a8"
SRC_URI[sha256sum] = "6c937cdfe15541ea4f239695e874533810c35ecf11e637c08d69d23757850ea4"

inherit pypi setuptools3

PYPI_PACKAGE = "boto3"

RDEPENDS_${PN} += " \
    python3-botocore \
    python3-jmespath \
    python3-s3transfer \
"
