DESCRIPTION = "Gateworks testing files"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

SECTION = "console/utils"
RDEPENDS_${PN} = " \
    bash \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-imx \
    gstreamer1.0-plugins-ugly \
    libasound alsa-utils alsa-state \
    fb-test fbset \
    v4l-utils \
"
DESTDIR = "/usr/bin"

PR = "r5"

SRC_URI = " \
    file://test_audio   \
    file://test_video   \
"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/${DESTDIR}
    install -m 0755 test_audio ${D}${DESTDIR}
    install -m 0755 test_video ${D}${DESTDIR}
}

FILES_${PN} = "${DESTDIR}/*"
