# Copyright (C) 2014 Gateworks Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

PR = "2"

DEPENDS += "lzop-native bc-native"

COMPATIBLE_MACHINE = "(ventana)"

# override URI of source and PR for Gateworks linux-imx kernel
UBOOT_ENTRYPOINT := "10008000"
SRCREV = "a17aaec0fd387ea9b5bae46fa1d2d576c95c1b45"
LOCALVERSION = "-1.1.0_beta+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git;protocol=git;branch=gateworks_3.10.31_1.1.0_beta file://defconfig"
