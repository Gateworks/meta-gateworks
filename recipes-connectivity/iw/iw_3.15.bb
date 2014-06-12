SUMMARY = "nl80211 based CLI configuration utility for wireless devices"
DESCRIPTION = "iw is a new nl80211 based CLI configuration utility for \
wireless devices. It supports almost all new drivers that have been added \
to the kernel recently. "
HOMEPAGE = "http://wireless.kernel.org/en/users/Documentation/iw"
SECTION = "base"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=878618a5c4af25e9b93ef0be1a93f774"

DEPENDS = "libnl pkgconfig"

SRC_URI = "https://www.kernel.org/pub/software/network/iw/iw-${PV}.tar.xz"

S = "${WORKDIR}/${PN}-${PV}"

EXTRA_OEMAKE = ""

do_install() {
    oe_runmake DESTDIR=${D} install
}

SRC_URI[md5sum] = "3b77ad7ec44a865a3bb2ab6c1c463bba"
SRC_URI[sha256sum] = "bd5c0a92cea799e22bcf431dfe0f91a3ba293ce078e9d95e53d7dbb26df24b8a"
