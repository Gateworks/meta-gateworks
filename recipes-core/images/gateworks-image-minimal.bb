require /usr/src/psidhu/oe/sources/poky/meta/recipes-core/images/core-image-base.bb

DESCRIPTION = "A very Minimal gateworks Ventana image "

LICENSE = "GPLv3"

# Include certain kernel modules
IMAGE_INSTALL_append_ventana += "kernel-module-sky2 canutils"

# Autoload sky2 on boot
module_autoload_sky2 = "sky2"

# Testing tools for i2cget, lspci etc
IMAGE_INSTALL_append += "i2c-tools mtd-utils pciutils usbutils"

# Include gateworks-test suite, but without any video/audio/gstreamer support

# Other stuff we want available en masse
IMAGE_INSTALL_append += "wget evtest memtester dropbear kobs-ng  \
			fsl-rc-local nbench-byte"