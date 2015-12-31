include compat-wireless.inc

SRC_URI += " \
	https://www.kernel.org/pub/linux/kernel/projects/backports/2015/01/29/backports-${PV}.tar.xz \
	file://add_db_txt.patch \
	file://defconfig \
	file://ath10k-fix_potential_Rx_ring_corruption.patch \
	file://ath10k_remove_thermal_no_sta_support_spew.patch \
"

COMPAT_WIRELESS_VERSION = "${PV}"

S = "${WORKDIR}/backports-${COMPAT_WIRELESS_VERSION}"

SRC_URI[md5sum] = "265bad6324b9b03422e4ac5342d31d67"
SRC_URI[sha256sum] = "6832e475178001c486ad4efd99a96e7717d248770536000938370f5606bfc85a"
