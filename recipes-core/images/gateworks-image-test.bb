require gateworks-image-minimal.bb

DESCRIPTION = "Small image capable of booting a device with support for the \
gateworks-test functions (i.e. test_audio, test_video, ...)"

# test tools
IMAGE_INSTALL += "gateworks-test"

## Required for video/audio tests in gateworks-test package ##
# GST Specific Packages
IMAGE_INSTALL_append += " \
	packagegroup-fsl-gstreamer                                   \
	gst-meta-video gst-meta-audio gst-meta-base                  \
	gst-plugins-base-videotestsrc gst-plugins-base-audiotestsrc  \
	gst-plugins-base-tcp                                         \
	gst-plugins-good-id3demux                                    \
        gst-fsl-plugin-gplay gst-plugins-ugly                        \
	"
# ALSA Specific Packages
IMAGE_INSTALL_append += " \
	gst-plugins-base-alsa \
	"
# Extra
IMAGE_INSTALL_append_ventana += " \
	gpu-viv-bin-mx6q libfslparser  \
	"
## End ##

# Firmware
IMAGE_INSTALL += "libfslvpuwrap"
