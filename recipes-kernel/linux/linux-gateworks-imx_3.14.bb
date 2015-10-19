# Copyright (C) 2015 Gateworks Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

PR = "7"

DEPENDS += "lzop-native bc-native"

# override URI of source and PR for Gateworks linux-imx kernel
SRCREV = "aab046c4c35193952fb70e374cbf9233d0113040"
SRC_BRANCH = "gateworks_fslc_3.14_1.0.x_ga"
LOCALVERSION = "-1.0.x_ga+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git;protocol=http;branch=${SRC_BRANCH}"

# use defconfig from arch/arm/configs
do_configure_prepend() {
    cp "${S}/arch/arm/configs/gwventana_defconfig" "${WORKDIR}/defconfig"
}

COMPATIBLE_MACHINE = "(ventana)"
