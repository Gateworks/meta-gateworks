require gateworks-image-multimedia.bb

DESCRIPTION = "Image that has a simple desktop user interface to fit within \
	    256MB flash"

include recipes-sato/images/core-image-sato.bb

IMAGE_INSTALL += " \
    u-boot-script-gateworks \
    midori \
    owl-video \
    "
