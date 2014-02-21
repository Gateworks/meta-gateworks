DESCRIPTION = "Simple Stress Test"
HOMEPAGE = "http://weather.ou.edu/~apw/projects/stress/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
SECTION = "console/utils"

SRC_URI = "http://dev.gateworks.com/sources/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "a607afa695a511765b40993a64c6e2f4"
SRC_URI[sha256sum] = "369c997f65e8426ae8b318d4fdc8e6f07a311cfa77cc4b25dace465c582163c0"

inherit autotools

S="${WORKDIR}/${PN}-${PV}"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 src/stress ${D}${bindir}
}

