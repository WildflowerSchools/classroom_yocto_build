FILESEXTRAPATHS_prepend := "${THISDIR}/../../../meta-openembedded/meta-python/recipes-devtools/python/python-pycrypto:"

inherit distutils3
require ../../../meta-openembedded/meta-python/recipes-devtools/python/python-pycrypto.inc

SRC_URI += "file://cross-compiling.patch \
            file://CVE-2013-7459.patch \
           "

# We explicitly call distutils_do_install, since we want it to run, but
# *don't* want the autotools install to run, since this package doesn't
# provide a "make install" target.
do_install() {
       distutils3_do_install
}
