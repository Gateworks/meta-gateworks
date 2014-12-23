# Copyright (C) 2014 Gateworks Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

PR = "1"

DEPENDS += "lzop-native bc-native"

COMPATIBLE_MACHINE = "(ventana)"

# override URI of source and PR for Gateworks linux-imx kernel
UBOOT_ENTRYPOINT := "10008000"
SRCREV = "8741bf86aaafbeeb8e3677a1b69b23b7537a7465"
LOCALVERSION = "-1.1.0_beta+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git;protocol=git;branch=gateworks_3.10.31_1.1.0_beta file://defconfig"
