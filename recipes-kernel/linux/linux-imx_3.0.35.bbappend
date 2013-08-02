FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# override URI of source and PR for Gateworks linux-imx kernel
PR = "4.0.0-gateworks-${INC_PR}.1"
SRCREV = "9e1faa6eec6b73d4d52fb826c89564298939c1bc"
LOCALVERSION ?= "-4.4.0-gateworks+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git \
           file://defconfig \
"
