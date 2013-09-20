require gateworks-image-minimal.bb

DESCRIPTION = "Gateworks Test Image"

# test tools
IMAGE_INSTALL += "\
        gateworks-test v4l-utils \
	"

IMAGE_ROOTFS_SIZE = "8192"

# remove not needed ipkg informations
ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "

## Required for video/audio tests in gateworks-test package ##
IMAGE_INSTALL_append +="\
	gstreamer                                                   \
	gst-plugins-base-videotestsrc gst-plugins-base-audiotestsrc \
	gst-plugins-base-alsa alsa-utils alsa-lib alsa-state        \
	"

# Firmware
IMAGE_INSTALL += "\
	libfslvpuwrap \
	"