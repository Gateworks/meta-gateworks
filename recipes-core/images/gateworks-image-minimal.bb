require recipes-core/images/core-image-base.bb

DESCRIPTION = "A minimal Gateworks image"

LICENSE = "GPLv3"

# Include certain utilities
IMAGE_INSTALL_append_ventana += "canutils"

# file system tools
IMAGE_INSTALL += "\
        mtd-utils \
        "

# Testing tools for i2cget, lspci etc
IMAGE_INSTALL_append += "\
	i2c-tools pciutils usbutils fb-test fbset iperf \
	"

IMAGE_FEATURES += "package-management"

# Useful tools
IMAGE_INSTALL_append += "\
	wget evtest memtester dropbear kobs-ng          \
	fsl-rc-local nbench-byte wireless-tools         \
	compat-wireless-all opkg                        \
	"

# Remove udev caching
ROOTFS_POSTPROCESS_COMMAND += "rm -rf ${IMAGE_ROOTFS}/etc/default/udev ; "

# EXTRA
IMAGE_INSTALL_append += "screen nano bash"