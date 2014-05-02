FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# override URI of source and PR for Gateworks linux-imx kernel
PR = "4.0.0-gateworks-${INC_PR}.9"
SRCREV = "aabbed94161dc42651694b79d4ffef1cd991b5c1"
LOCALVERSION = "-4.4.0-gateworks+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git;protocol=git;branch=gateworks_3.0.35_4.0.0 file://defconfig"
