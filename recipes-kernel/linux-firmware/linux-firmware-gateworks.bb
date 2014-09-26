# This recipe adds specific firmware for cards that we feel users will want to use
# This is a customized version of the poky/meta/recipes-kernel/linux-firmware recipe.

SUMMARY = "Hand selected linux firmware binary blobs for Gateworks SBC's"
SECTION = "kernel"

# Choosing proprietary license because licenses differ per firmware binary
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://LICENCE.iwlwifi_firmware;md5=5106226b2863d00d8ed553221ddf8cd2 \
                    file://LICENCE.ibt_firmware;md5=fdbee1ddfe0fb7ab0b2fcd6b454a366b \
                    file://LICENCE.atheros_firmware;md5=30a14c7823beedac9fa39c64fdd01a13 \
                   "

inherit allarch

# Using latest (20140902) rev of linux-firmware
SRCREV = "f66291398181d24856fd2d19454d246199abd5ea"
PE = "1"
PV = "0.0+git${SRCPV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/firmware/linux-firmware.git"

S = "${WORKDIR}/git"

# Firmware to install onto rootfs + any licenses
INSTALL_FW = "ar3k/*.dfu intel/*.bseq iwlwifi-7260-9.ucode \
              LICENCE.atheros_firmware LICENCE.ibt_firmware LICENCE.iwlwifi_firmware"

do_compile() {
    :
}

# Only install drivers we want as listed in INSTALL_DRIVERS
do_install() {
    install -d ${D}/lib/firmware/
    for fw in $(ls ${INSTALL_FW}); do
	local dir=$(dirname ${fw})
	if [ "$dir" != "." ]; then
	    mkdir -p ${D}/lib/firmware/${fw%\/*}
	fi
	cp ${fw} ${D}/lib/firmware/${fw}
    done
}

PACKAGES = "${PN}"
FILES_${PN} = "${base_libdir}/firmware/*"
