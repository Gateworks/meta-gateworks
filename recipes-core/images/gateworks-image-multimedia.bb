require gateworks-image-minimal.bb

DESCRIPTION = "Gateworks Multimedia Image capable of doing A/V"

LICENSE = "MIT"

# Gateworks test tools
IMAGE_INSTALL += "gateworks-test gst-gateworks-apps"

# graphics and gstreamer plugins
IMAGE_INSTALL += "\
    gstreamer1.0-plugins-imx-meta \
    gstreamer1.0-rtsp-server \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    ${@bb.utils.contains('LICENSE_FLAGS_WHITELIST', 'commercial', 'gstreamer1.0-plugins-ugly', '', d)} \
    ${@bb.utils.contains('LICENSE_FLAGS_WHITELIST', 'commercial', 'gstreamer1.0-libav', '', d)} \
    fsl-alsa-plugins \
    imx-codec \
    imx-codec-aac \
    imx-codec-bmp \
    imx-codec-bsac \
    imx-codec-flac \
    imx-codec-g.711 \
    imx-codec-g.723.1 \
    imx-codec-g.726 \
    imx-codec-g.729ab \
    imx-codec-gif \
    imx-codec-h264 \
    imx-codec-jpeg \
    imx-codec-meta \
    imx-codec-mp3 \
    imx-codec-mpeg2 \
    imx-codec-mpeg4asp \
    imx-codec-nb \
    imx-codec-oggvorbis \
    imx-codec-peq \
    imx-codec-png \
    imx-codec-sbc \
    imx-codec-src \
    imx-codec-wb \
    imx-parser \
"

# Audio packages
IMAGE_INSTALL += "\
    libasound alsa-utils alsa-state \
"
