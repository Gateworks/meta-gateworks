require recipes-core/images/core-image-base.bb
inherit ubi-config

DESCRIPTION = "A minimal Gateworks image"

LICENSE = "GPLv3"

IMAGE_FEATURES += "package-management"

# Wireless/networking
IMAGE_INSTALL += "\
	canutils \
	iw \
	wpa-supplicant \
	hostap-daemon \
	wireless-tools \
	compat-wireless-all \
	dropbear \
	dnsmasq \
	bridge-utils \
	"

# FLASH tools
IMAGE_INSTALL += "\
	mtd-utils \
	imx-kobs \
	"

# Testing tools for i2cget, lspci etc
IMAGE_INSTALL += "\
	i2c-tools pciutils usbutils fb-test fbset iperf devmem2 watchdog \
	wget evtest memtester screen nano bash nbench-byte stress \
	"

# Useful tools
IMAGE_INSTALL += "\
	fsl-rc-local opkg \
	"

# devicetree files
IMAGE_INSTALL += "kernel-devicetree"

# Remove udev caching
ROOTFS_POSTPROCESS_COMMAND += "rm -rf ${IMAGE_ROOTFS}/etc/default/udev ; "
