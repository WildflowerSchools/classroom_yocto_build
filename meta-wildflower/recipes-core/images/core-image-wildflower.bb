SUMMARY = "An image with Wildflower tools"
HOMEPAGE = "https://github.com/WildflowerSchools/"
LICENSE = "MIT"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

inherit core-image

DEPENDS += "bcm2835-bootfiles"

CORE_OS = " \
    openssh openssh-keygen openssh-sftp-server \
    openvpn \
    tzdata \
    ntp \
    wildflower-misc \
"

WIFI_SUPPORT = " \
    crda \
    iw \
    linux-firmware-bcm43430 \
    wireless-tools \
    wpa-supplicant \
    avahi-daemon \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${WIFI_SUPPORT} \
    vim \
    tmux \
"

export IMAGE_BASENAME = "core-image-wildflower"

