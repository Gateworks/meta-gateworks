include compat-wireless.inc

SRC_URI = " \
	https://www.kernel.org/pub/linux/kernel/projects/backports/2014/08/08/backports-${PV}.tar.xz \
	file://0001-disable_kconf.patch \
	file://0010-ath10k_fix_monitor_start_stop_sequences.patch \
	file://0011-ath10k_stop_monitor_vdev_for_sta_assoc.patch \
	file://add_db_txt.patch \
	file://defconfig \
"

COMPAT_WIRELESS_VERSION = "${PV}"

S = "${WORKDIR}/backports-${COMPAT_WIRELESS_VERSION}"

SRC_URI[md5sum] = "4898cde81f9a07a4a7ea23376d68dbee"
SRC_URI[sha256sum] = "227b69ceb14369bcc5b88951a6cb8c6ff302d4409736dff9f86e0465f469f973"

