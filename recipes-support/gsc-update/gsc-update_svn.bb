SUMMARY = "Gateworks program that allows updating of the GSC firmware"
SECTION = "base"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PV = "v1.5+svnr${SRCPV}"

SRCREV = "812"
SRC_URI = "\
    svn://svn.gateworks.com/openwrt/packages/gateworks/;protocol=http;module=${PN} \
    file://0001-Makefile_remove_stripping.patch \
"

S = "${WORKDIR}/${PN}/src/"
TARGET = "gsc_update"

do_compile() {
    make ${TARGET}
}

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${S}${TARGET} ${D}${sbindir}
}
