# Override imx-kobs package to update it to 5.4 version + patches
# to make it work with kernels with raw read/write support

SUMMARY = "Nand boot write source"
SECTION = "base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = " \
    ${FSL_MIRROR}/imx-kobs-${PV}.tar.gz \
    file://0001-src-mtd-fix-compilation-with-certain-c-libraries.patch \
    file://0002-src-add-chip_0_size-param.patch \
    file://0003-src-mtd-use-kernel-version-method-for-raw_mode-check.patch \
    file://0004-src-mtd-fix-default-bch-geometry.patch \
"

SRC_URI[md5sum] = "77467d834f858c2ec216841583e5f437"
SRC_URI[sha256sum] = "85171b46068ac47c42fedb8104167bf9afd33dd9527ed127e1ca2eb29d7a86bf"

inherit  autotools pkgconfig
