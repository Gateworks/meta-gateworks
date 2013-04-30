# Copyright (C) 2012 Gateworks Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "bootloader for imx platforms"
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

PR = "r1"

SRCREV = "2536850d7cd90bdb75bf3ff86838f913392b68db"
SRC_URI = "git://git.denx.de/u-boot"
SRC_URI_append_ventana = " \
           file://gateworks_ventana.patch \
"

UBOOT_MAKE_TARGET = ""

S = "${WORKDIR}/git"
EXTRA_OEMAKE += 'HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(ventana)"
