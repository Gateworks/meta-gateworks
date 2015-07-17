DESCRIPTION = "Ath10k 802.11ac driver firmware"
HOMEPAGE = "http://wireless.kernel.org/en/users/Drivers/ath10k/firmware"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://LICENSE.qca_firmware;md5=0ab1b291e8bb10e4858a699bae761d1b"

SRCREV = "38eeda3ae6f90fde5546bdd48ee4ff3090f238c0"
LOCALVERSION = "-g38eeda3a"
SRC_URI = "git://github.com/kvalo/ath10k-firmware;protocol=http;branch=master"

DEFAULT_FW = "10.1.467.2-1"

S = "${WORKDIR}/git"

inherit allarch

do_install() {
    install -d ${D}${base_libdir}/firmware/ath10k/QCA988X/hw2.0/
    install -m 0644 ${S}/ath10k/QCA988X/hw2.0/board.bin ${D}${base_libdir}/firmware/ath10k/QCA988X/hw2.0/
    install -m 0644 ${S}/10.1/firmware-2.bin_10.1.467.2-1 ${D}${base_libdir}/firmware/ath10k/QCA988X/hw2.0/
    install -m 0644 ${S}/main/firmware-2.bin_999.999.0.636 ${D}${base_libdir}/firmware/ath10k/QCA988X/hw2.0/
    ln -sf firmware-2.bin_${DEFAULT_FW} ${D}/${base_libdir}/firmware/ath10k/QCA988X/hw2.0/firmware-2.bin
}

PACKAGES = "${PN}"
FILES_${PN} = "${base_libdir}/firmware/ath10k"

