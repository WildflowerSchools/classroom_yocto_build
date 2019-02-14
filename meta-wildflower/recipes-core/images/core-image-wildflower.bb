SUMMARY = "An image with Wildflower tools"
HOMEPAGE = "https://github.com/WildflowerSchools/"
LICENSE = "MIT"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

inherit core-image


CORE_OS = " \
    openssh openssh-keygen openssh-sftp-server \
    openvpn \
    tzdata \
    ntp \
    wildflower-misc-hostname \
    salt-minion \
"

WIFI_SUPPORT = " \
    crda \
    iw \
    linux-firmware-raspbian-bcm43430 \
    linux-firmware-raspbian-bcm43455 \
    iw \
    wildflower-misc-net \
    avahi-daemon \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${WIFI_SUPPORT} \
    vim \
    tmux \
    procps \
    dosfstools \
    pyaci-collector \
    pyaci-uploader \
    sensei-camera-upload \
    docker \
    sudo \
"

export IMAGE_BASENAME = "core-image-wildflower"

