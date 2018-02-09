require gateworks-image-multimedia.bb

DESCRIPTION = "A simple X11 based image that includes a web browser"

LICENSE = "MIT"

IMAGE_FEATURES += "x11-base x11-sato hwcodecs"

REQUIRED_DISTRO_FEATURES = "x11"

# Install browser and x11
IMAGE_INSTALL += "\
    packagegroup-core-x11-sato \
    epiphany \
    mesa-demos \
"

# FSL Specific Packages
IMAGE_INSTALL += "\
    packagegroup-fsl-tools-gpu \
"

# Qt5 Demo
IMAGE_INSTALL += "\
   qtbase \
   qtbase-plugins \
   qtdeclarative \
   qtdeclarative-plugins \
   qtdeclarative-qmlplugins \
   qtimageformats \
   qtimageformats-plugins \
   qtdeclarative-tools \
   qtgraphicaleffects-qmlplugins \
   qtquickcontrols-qmlplugins \
   qtquickcontrols2-qmlplugins \
   qtglviddemo \
"

# Only build large ubi image
MULTIUBI_BUILD = "large"
