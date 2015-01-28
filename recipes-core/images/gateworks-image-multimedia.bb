require gateworks-image-minimal.bb

DESCRIPTION = "Image capable of booting a device with support for the \
	gateworks-test functions (i.e. test_audio, test_video, ...)"

# test tools
IMAGE_INSTALL += "gateworks-test"

# graphics and gstreamer plugins
IMAGE_INSTALL += "\
    packagegroup-fsl-gstreamer \
    gst-plugins-base-meta \
    gst-plugins-good-meta \
    gst-plugins-bad-meta \
    gst-plugins-ugly-meta \
"

# Audio packages
IMAGE_INSTALL += "\
    alsa-utils alsa-lib alsa-state \
"
