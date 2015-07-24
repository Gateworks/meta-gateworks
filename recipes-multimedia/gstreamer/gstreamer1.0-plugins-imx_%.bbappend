FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PV = "0.11.0"

# Use the latest (as of 07/24/2015) gstreamer-imx (Version 0.11.0)
SRCREV = "729ecfe767b3f8acde3ab0e1a0463d8a2b789c51"

SRC_URI_append = " file://0001-imxv4l2videosrc-v4l2_buffer_pool-Add-special-case-fo.patch"
