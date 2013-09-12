FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# override URI of source and PR for Gateworks linux-imx kernel
PR = "4.0.0-gateworks-${INC_PR}.4"
SRCREV = "ec690b4b2108d601c3d54b2313e7bf31b069bde9"
LOCALVERSION ?= "-4.4.0-gateworks+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git \
           file://defconfig \
"
