require gateworks-image-minimal.bb

DESCRIPTION = "Gateworks Test Image"

IMAGE_ROOTFS_SIZE = "8192"

# test tools
IMAGE_INSTALL += "\
	gateworks-test \
	"

# remove not needed ipkg informations
#ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "
