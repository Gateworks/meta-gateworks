require gateworks-image-multimedia.bb

DESCRIPTION = "Image that has a simple desktop user interface to fit within \
	    256MB flash"

include recipes-sato/images/core-image-sato.bb

DISTRO_FEATURES += "pulseaudio"
WEB = "web-webkit"

IMAGE_INSTALL += " \
    xf86-video-fbdev \
    midori \
    cpufrequtils \
    qt4-plugin-phonon-backend-gstreamer \
    fsl-gui-extrafiles \
    "
