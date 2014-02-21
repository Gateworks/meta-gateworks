# Copyright (C) 2014 Gateworks Corporation

DESCRIPTION = "bootloader for Gateworks Ventana"
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"

SRCREV = "3a3583f5e7d118de8d067f9bc34c03224f478b0d"
SRC_URI = "git://github.com/Gateworks/u-boot-imx6.git;protocol=git;branch=gateworks_v2014.01"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(ventana)"
