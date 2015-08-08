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

do_install_append() {
    install -m 0644 ${WORKDIR}/fw_env_nand.config ${D}${sysconfdir}/fw_env_nand.config
    install -m 0644 ${WORKDIR}/fw_env_usd.config ${D}${sysconfdir}/fw_env_usd.config
}

pkg_postinst_${PN}() {
#!/bin/sh -e

if [ x"$D" = "x" ]; then # Only run on boot time
    cd ${sysconfdir}
    if [ -c /dev/mtd1 ]; then
        ln -sf fw_env_nand.config fw_env.config
    else
        ln -sf fw_env_usd.config fw_env.config
    fi
else
    exit 1
fi
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(ventana)"
