DESCRIPTION = "hostapd conf creator"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

SECTION = "console/utils"
RDEPENDS_${PN} = " \
    bash sed iw \
"

PR = "r0"

SRC_URI = " \
    file://hostapd-conf \
"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 hostapd-conf ${D}${bindir}
}
