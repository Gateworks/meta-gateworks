require recipes-core/images/core-image-base.bb

DESCRIPTION = "Gateworks Minimal Image"

LICENSE = "MIT"

IMAGE_FEATURES += "package-management"

# Test tools and service package to include in Gateworks base image
IMAGE_INSTALL += " \
    bash \
    cpufrequtils \
    devmem2 \
    evtest \
    fb-test \
    fbset \
    fsl-rc-local \
    glibc-gconv-utf-16 \
    gpsd \
    gsc-update \
    gwsoc \
    i2c-tools \
    imx-kobs \
    iperf \
    iperf3 \
    memtester \
    mtd-utils \
    mtd-utils-ubifs \
    nbench-byte \
    opkg \
    pciutils \
    screen \
    stress \
    u-boot-fw-utils \
    usbutils \
    v4l-utils \
    watchdog \
"

# Wireless/Networking Packages
IMAGE_INSTALL += " \
    bridge-utils \
    canutils \
    compat-wireless-all \
    dnsmasq \
    dropbear \
    ethtool \
    hostapd \
    hostapd-conf \
    iproute2 \
    iw \
    linux-firmware-gateworks \
    linuxptp \
    wireless-tools \
    wpa-supplicant \
"
