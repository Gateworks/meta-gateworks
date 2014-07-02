SUMMARY = "canutils (VW flavour)"
HOMEPAGE = ""
SECTION = "console/network"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRCREV = "67a2bdcd336e6becfa5784742e18c88dbeddc973"
SRC_URI = "git://gitorious.org/linux-can/can-utils.git;protocol=git"

S = "${WORKDIR}/git"

inherit autotools
