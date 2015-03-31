require gateworks-image-multimedia.bb

DESCRIPTION = "Image that has a simple desktop user interface which includes a \
browser and several media players"

IMAGE_FEATURES += "splash package-management x11-base x11-sato hwcodecs"

# SATO image specifics
IMAGE_INSTALL += " \
    packagegroup-core-x11-sato \
    midori \
"

# FSL Specifics
IMAGE_INSTALL += " \
    packagegroup-fsl-tools-gpu \
    vivante-gpu-sdk \
    "

# Only build a UBI with 'large' settings
MULTIUBI_BUILD = "large"
