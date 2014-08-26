FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# override URI of source and PR for Gateworks linux-imx kernel
PR = "4.0.0-gateworks-${INC_PR}.11"
SRCREV = "2aee2176ee6fa8bd6c9a4bfa137882a7ba559e96"
LOCALVERSION = "-4.4.0-gateworks+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git;protocol=git;branch=gateworks_3.0.35_4.0.0 file://defconfig"
