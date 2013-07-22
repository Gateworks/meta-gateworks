DESCRIPTION = "Application for Programming NAND FLASH for i.MX53/i.MX6"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"
SECTION = "console/utils"

SRC_URI = "http://repository.timesys.com/buildsources/k/${PN}/${PN}-${PV}/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "1eea815fa78ff794c9d111260cf49a84"
SRC_URI[sha256sum] = "49d1503d97a5ac7ff54c48b28f300497c3edf665f996c826ef88dde1883142aa"

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

