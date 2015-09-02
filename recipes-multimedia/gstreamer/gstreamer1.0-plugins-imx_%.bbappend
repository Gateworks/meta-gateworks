FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# Use latest as of Aug 23, 2015
SRCREV = "606a077c3ddd0a9d7280fbd6c0729b281c8b9175"
PV = "0.11.1+${SRCPV}"

SRC_URI_append = " file://0001-imxv4l2videosrc-v4l2_buffer_pool-Add-special-case-fo.patch"
