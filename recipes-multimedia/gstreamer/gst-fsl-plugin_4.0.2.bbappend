FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR := "${PR}"

SRC_URI += "file://yuv422.patch"
