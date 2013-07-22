DESCRIPTION = "Application for Programming NAND FLASH for i.MX53/i.MX6"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"
SECTION = "console/utils"

# Note: Must obtain the source from L3.0.35_4.0.0_ER_SOURCE
#SRC_URI = "http://freescale.com/${PN}-${PV}.tar.gz"
SRC_URI = "http://192.168.1.146/tftpboot/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "26104c577f59a6b81782a5bd16aadd82"
SRC_URI[sha256sum] = "616397a7af7e12ccdabb79d599fab59ede1a130a9a70fe85eaeb52c9e9bcdafa"

inherit autotools

S="${WORKDIR}/${PN}-${PV}"

do_compile() {
	echo "const char* git_sha = \"${PV}\";" > ${S}/src/autoversion.h
	oe_runmake
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 src/kobs-ng ${D}${bindir}
}

