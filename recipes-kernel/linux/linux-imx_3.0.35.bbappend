FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# override URI of source and PR for Gateworks linux-imx kernel
PR = "4.0.0-gateworks-${INC_PR}.3"
SRCREV = "e4784013dad6f5f80efea654e9b1b1d3b0693b32"
LOCALVERSION ?= "-4.4.0-gateworks+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git \
           file://defconfig \
"
