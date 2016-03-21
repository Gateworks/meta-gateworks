include compat-wireless.inc

SRC_URI += " \
	https://www.kernel.org/pub/linux/kernel/projects/backports/2016/01/22/backports-${PV}.tar.xz \
	file://add_db_txt.patch \
	file://defconfig \
"

COMPAT_WIRELESS_VERSION = "${PV}"

S = "${WORKDIR}/backports-${COMPAT_WIRELESS_VERSION}"

SRC_URI[md5sum] = "70e45420d9d25af03fb4fb21385ba4a9"
SRC_URI[sha256sum] = "037164cbcec3ae85b0f9ca9151e09277e657f24fc9258f24f77c0267a2ef1ece"
