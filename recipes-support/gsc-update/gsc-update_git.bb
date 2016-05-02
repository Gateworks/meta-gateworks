SUMMARY = "Gateworks program that allows updating of the GSC firmware"
SECTION = "base"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PV = "1.5+${SRCREV}"
SRC_BRANCH = "master"
SRCREV = "ccc9877ae330c2f713fe29c7f55f55997b49c627"
SRC_URI = "git://github.com/gateworks/gsc_update.git;protocol=git;branch=${SRC_BRANCH}"

S = "${WORKDIR}/git"

inherit pkgconfig

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${S}/gsc_update ${D}${sbindir}
}

