require recipes-core/images/core-image-base.bb

DESCRIPTION = "A minimal Gateworks Ventana image"

LICENSE = "GPLv3"

# Include certain kernel modules
IMAGE_INSTALL_append_ventana += "kernel-module-sky2 canutils"

# Autoload sky2 on boot
module_autoload_sky2 = "sky2"

# file system tools
IMAGE_INSTALL += "\
        mtd-utils \
        "

# Testing tools for i2cget, lspci etc
IMAGE_INSTALL_append += "\
	i2c-tools mtd-utils pciutils usbutils fb-test fbset \
	iperf                                               \
	"

# Other stuff we want available en masse
IMAGE_INSTALL_append += "\
	wget evtest memtester dropbear kobs-ng       \
	fsl-rc-local nbench-byte wireless-tools      \
	compat-wireless-all                          \
	"

# EXTRA
IMAGE_INSTALL_append += "screen nano bash"