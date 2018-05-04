SUMMARY = "Amazon S3 Transfer Manager"
HOMEPAGE = "https://pypi.python.org/pypi/s3transfer"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b1e01b26bacfc2232046c90a330332b3"

SRC_URI[md5sum] = "b7437bbbd3195e916f9e992b78721067"
SRC_URI[sha256sum] = "90dc18e028989c609146e241ea153250be451e05ecc0c2832565231dacdf59c1"

inherit pypi setuptools3

PYPI_PACKAGE = "s3transfer"

RDEPENDS_${PN} += " \
    python3-misc \
    python3-math \
    python3-stringold \
    python3-multiprocessing \
"
