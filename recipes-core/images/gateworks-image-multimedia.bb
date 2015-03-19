require gateworks-image-minimal.bb

DESCRIPTION = "Image capable of booting a device with support for the \
gateworks-test functions (i.e. test_audio, test_video, ...)"

# test tools
IMAGE_INSTALL += "gateworks-test"

# graphics and gstreamer plugins
IMAGE_INSTALL += "\
    packagegroup-fsl-gstreamer-full \
    gst-fsl-plugin \
    gst-plugins-base-meta \
    gst-plugins-good-meta \
    gst-plugins-bad-meta \
    gst-plugins-ugly-meta \
    \
    packagegroup-fslc-gstreamer1.0-full \
    gstreamer1.0-meta-base \
    gst1.0-fsl-plugin \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta \
    gstreamer1.0-plugins-bad-meta \
    gstreamer1.0-plugins-ugly-meta \
"

# Audio packages
IMAGE_INSTALL += "\
    alsa-utils alsa-lib alsa-state \
"
