require recipes-multimedia/gstreamer/gst-plugins-package.inc
require gateworks-image-minimal.bb

DESCRIPTION = "Image capable of booting a device with support for the \
	    gateworks-test functions (i.e. test_audio, test_video, ...)"

# test tools
IMAGE_INSTALL += "gateworks-test"

# GST Specific Packages
IMAGE_INSTALL +="\
	packagegroup-fsl-gstreamer                                    \
	gst-ffmpeg gst-fsl-plugin-gplay	                              \
	gst-meta-video gst-meta-audio gst-meta-base                   \
	gst-plugins-base-videotestsrc gst-plugins-base-audiotestsrc   \
	gst-plugins-base-alsa gst-plugins-base-tcp                    \
	gst-plugins-good-imagefreeze gst-plugins-good-png             \
	gst-plugins-good-jpeg gst-plugins-good-id3demux               \
	gst-plugins-good-rtp gst-plugins-good-rtpmanager              \
	gst-plugins-bad gst-plugins-bad-fbdevsink                     \
	gst-plugins-ugly gst-plugins-ugly-mad gst-plugins-ugly-a52dec \
	gst-plugins-ugly-mpegaudioparse gst-plugins-ugly-mpeg2dec     \
	gpu-viv-bin-mx6q libfslparser                                 \
	"
