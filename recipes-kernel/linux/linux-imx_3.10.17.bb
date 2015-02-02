# Copyright (C) 2014 Gateworks Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

PR = "10"

DEPENDS += "lzop-native bc-native"

COMPATIBLE_MACHINE = "(ventana)"

# override URI of source and PR for Gateworks linux-imx kernel
SRCREV = "e86e8d6c811d4660655998b8fc5a2b7115595424"
LOCALVERSION = "-1.0.0_ga+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git;protocol=git;branch=gateworks_3.10.17_1.0.0_ga file://defconfig"
