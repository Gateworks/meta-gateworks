FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DESCRIPTION = "u-boot-fw-utils overrides for Gateworks Ventana Family SBC's"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"

PV = "v2015.04+git${SRCPV}"

SRCREV = "1c2abb3c753d25e4d11252e0319bdfc8634e7efb"
SRC_URI = " \
    git://github.com/Gateworks/u-boot-imx6.git;branch=gateworks_v2015.04 \
    file://fw_env_nand.config \
    file://fw_env_usd.config \
"

FW_UTILS_CONFIG_FILE ?= "fw_env_nand.config"

do_install_append() {
    install -m 0644 ${WORKDIR}/fw_env_nand.config ${D}${sysconfdir}/fw_env_nand.config
    install -m 0644 ${WORKDIR}/fw_env_usd.config ${D}${sysconfdir}/fw_env_usd.config
    cd ${D}${sysconfdir}
    ln -sf ${FW_UTILS_CONFIG_FILE} fw_env.config
    cd -
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(ventana)"
