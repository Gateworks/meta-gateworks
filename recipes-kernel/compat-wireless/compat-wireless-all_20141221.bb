include compat-wireless.inc

SRC_URI = " \
	https://www.kernel.org/pub/linux/kernel/projects/backports/2014/12/21/backports-${PV}.tar.xz \
	file://0001-disable_kconf.patch \
	file://0002-define_reinit.patch \
	file://add_db_txt.patch \
	file://defconfig \
"

COMPAT_WIRELESS_VERSION = "${PV}"

S = "${WORKDIR}/backports-${COMPAT_WIRELESS_VERSION}"

SRC_URI[md5sum] = "5a45958539dc0b446f7570216fcf435e"
SRC_URI[sha256sum] = "0bfc9d89a9c8f76d321f4f9ed2727ee3ced1588d3c8403e90609aa8fa0a69cce"
