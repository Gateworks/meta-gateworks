DESCRIPTION = "GWSoC configure/update utility"
HOMEPAGE = "http://github.com/Gateworks/gwsoc/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"
SECTION = "console/utils"

DEPENDS = "hid-api"

SRCREV = "a618115bd0720c6940d03b47ed9b41320d74e445"
SRC_URI = "git://github.com/Gateworks/gwsoc.git;protocol=http"

PV = "1.0+${SRCREV}"

S="${WORKDIR}/git/gwsoc"

do_compile() {
	make
}

do_install() {
	install -d ${D}${sbindir}
	install -m 0755 gwsoc ${D}${sbindir}
}

