require gateworks-image-multimedia.bb

DESCRIPTION = "A simple X11 based image that includes a web browser"

LICENSE = "MIT"

IMAGE_FEATURES += "x11-base x11-sato hwcodecs"

# Install browser and x11
IMAGE_INSTALL += "\
    packagegroup-core-x11-sato \
    midori \
"

# FSL Specific Packages
IMAGE_INSTALL += "\
    packagegroup-fsl-tools-gpu \
    vivante-gpu-sdk \
"

# Only build large ubi image
MULTIUBI_BUILD = "large"
