# Copyright (C) 2014 Gateworks Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

PR = "16"

DEPENDS += "lzop-native bc-native"

COMPATIBLE_MACHINE = "(ventana)"

# override URI of source and PR for Gateworks linux-imx kernel
SRCREV = "9dfab1b4e9a0f1a3d1766acca259a7694d72ef33"
LOCALVERSION = "-1.0.0_ga+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git;protocol=git;branch=gateworks_3.10.17_1.0.0_ga"

# use defconfig from arch/arm/configs
do_configure_prepend() {
	cp "${S}/arch/arm/configs/gwventana_defconfig" "${WORKDIR}/defconfig"
}
