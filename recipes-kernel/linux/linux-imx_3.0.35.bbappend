FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# override URI of source and PR for Gateworks linux-imx kernel
PR = "4.0.0-gateworks-${INC_PR}.7"
SRCREV = "9df3236992382a2b248ce890d9aaf19a204bb717"
LOCALVERSION ?= "-4.4.0-gateworks+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git \
           file://defconfig \
"
