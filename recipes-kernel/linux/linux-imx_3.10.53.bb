# Copyright (C) 2014 Gateworks Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

PR = "2"

DEPENDS += "lzop-native bc-native"

COMPATIBLE_MACHINE = "(ventana)"

# override URI of source and PR for Gateworks linux-imx kernel
UBOOT_ENTRYPOINT := "10008000"
SRCREV = "2dc09f74a9f993bad3c572dae8c1cef122506c61"
LOCALVERSION = "-1.1.0_ga+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git;protocol=git;branch=gateworks_3.10.53_1.1.0_ga"

# use defconfig from arch/arm/configs
do_configure_prepend() {
    cp "${S}/arch/arm/configs/gwventana_defconfig" "${WORKDIR}/defconfig"
}
