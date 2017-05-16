require gateworks-image-minimal.bb

DESCRIPTION = "Gateworks Test Image Used in Production Testing"

LICENSE = "MIT"

# Gateworks test tools
IMAGE_INSTALL += "gateworks-test"
