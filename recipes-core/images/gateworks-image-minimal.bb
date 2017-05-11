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
    iperf3 \
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
    iptables \
    canutils \
    compat-wireless-all \
    dnsmasq \
    dropbear \
    ethtool \
    hostapd \
    hostapd-conf \
    iproute2 \
    iw \
    linuxptp \
    wireless-tools \
    wpa-supplicant \
"

# Firmware
IMAGE_INSTALL += " \
    linux-firmware-ath10k \
    linux-firmware-ath9k \
    linux-firmware-iwlwifi-7260 \
    linux-firmware-iwlwifi-7265 \
    linux-firmware-ar3k \
"

# Crypto
IMAGE_INSTALL += " \
    cryptodev-module \
"

# Scripting
IMAGE_INSTALL += " \
    perl \
    \
    python \
    python-codecs \
    python-crypt \
    python-datetime \
    python-dbus \
    python-io \
    python-logging \
    python-math \
    python-mime \
    python-netclient \
    python-pickle \
    python-pygobject \
    python-stringold \
    python-textutils \
    python-threading \
    python-xml \
"
