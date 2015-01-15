require gateworks-image-multimedia.bb

DESCRIPTION = "Image that has a simple desktop user interface which includes a \
    browser and several media players"

include recipes-sato/images/core-image-sato.bb

IMAGE_INSTALL += " \
    u-boot-script-gateworks \
    midori \
    owl-video \
    "

IMAGE_INSTALL += " \
    packagegroup-fsl-tools-gpu \
    vivante-gpu-sdk \
    "

# Only build a UBI with 'large' settings
MULTIUBI_BUILD = "large"
