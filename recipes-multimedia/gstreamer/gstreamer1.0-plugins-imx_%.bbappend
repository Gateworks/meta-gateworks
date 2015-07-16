FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# Use the latest (as of 07/14/2015) gstreamer-imx
SRCREV = "b7aedb150b7edbd39d9b86d9445b13ccf09b0b9e"

SRC_URI_append = " file://0001-imxv4l2videosrc-v4l2_buffer_pool-Add-special-case-fo.patch"
