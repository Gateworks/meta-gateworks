# Copyright (C) 2014 Gateworks Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

PR = "0"

DEPENDS += "lzop-native bc-native"

COMPATIBLE_MACHINE = "(ventana)"

# override URI of source and PR for Gateworks linux-imx kernel
UBOOT_ENTRYPOINT := "10008000"
SRCREV = "a147ebbedfc18abb2b3875046ba6bf1b2b23faa7"
LOCALVERSION = "-1.1.0_ga+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git;protocol=git;branch=gateworks_3.10.53_1.1.0_ga file://defconfig"
