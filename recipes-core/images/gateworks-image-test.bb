require recipes-core/images/core-image-base.bb

DESCRIPTION = "Gateworks Test Image"

LICENSE = "GPLv3"

IMAGE_FEATURES += "package-management"

# Gateworks test tools
IMAGE_INSTALL += "gateworks-test gst-gateworks-apps"

# graphics and gstreamer plugins
IMAGE_INSTALL += "\
    packagegroup-fslc-gstreamer1.0-full \
    gstreamer1.0-meta-base \
    gstreamer1.0-plugins-imx \
    gstreamer1.0-rtsp-server \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta \
    gstreamer1.0-plugins-bad-meta \
    gstreamer1.0-plugins-ugly-meta \
"

# Audio packages
IMAGE_INSTALL += "\
    alsa-utils alsa-lib alsa-state \
"
