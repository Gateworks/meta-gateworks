DESCRIPTION = "Gateworks testing files"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

SECTION = "console/utils"
RDEPENDS_${PN} = " \
	gstreamer                                                    \
	packagegroup-fsl-gstreamer                                   \
	gst-plugins-base-alsa alsa-utils alsa-lib alsa-state         \
	gst-meta-video gst-meta-audio gst-meta-base                  \
	gst-plugins-base-videotestsrc gst-plugins-base-audiotestsrc  \
	gst-plugins-base-tcp                                         \
	gst-plugins-good-id3demux                                    \
	gst-plugins-bad-fbdevsink                                    \
	gst-fsl-plugin-gplay gst-plugins-ugly                        \
	fb-test fbset                                                \
	v4l-utils \
  "
DESTDIR = "/usr/bin"

PR = "r3"

SRC_URI = " \
	file://test_audio   \
	file://test_video   \
	file://playVideo    \
"

S = "${WORKDIR}"

do_install() {
	install -d ${D}/${DESTDIR}
	install -m 0755 test_audio ${D}${DESTDIR}
	install -m 0755 test_video ${D}${DESTDIR}
	install -m 0755 playVideo ${D}${DESTDIR}
}

FILES_${PN} = "${DESTDIR}/*"
