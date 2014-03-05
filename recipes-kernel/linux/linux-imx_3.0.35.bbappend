FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# override URI of source and PR for Gateworks linux-imx kernel
PR = "4.0.0-gateworks-${INC_PR}.8"
SRCREV = "3830df019fa1cf21c1aa0633e4d274155e2bafde"
LOCALVERSION ?= "-4.4.0-gateworks+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git;protocol=git;branch=gateworks_3.0.35_4.0.0 file://defconfig"
