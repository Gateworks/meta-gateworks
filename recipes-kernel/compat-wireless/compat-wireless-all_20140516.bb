include compat-wireless.inc

SRC_URI = " \
	https://www.kernel.org/pub/linux/kernel/projects/backports/2014/05/16/backports-${PV}.tar.xz \
	file://0001-disable_kconf.patch \
	file://defconfig"

COMPAT_WIRELESS_VERSION = "${PV}"

S = "${WORKDIR}/backports-${COMPAT_WIRELESS_VERSION}"

SRC_URI[md5sum] = "9d3611d4ba951cfdd46848fc5db6e9a9"
SRC_URI[sha256sum] = "649a68c91522ba581a211fea4f1a82028c21aa5081ee9df1d939e5e5d0d95425"

