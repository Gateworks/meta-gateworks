# This recipe adds specific firmware for cards that we feel users will want to use
# This is a customized version of the poky/meta/recipes-kernel/linux-firmware recipe.

SUMMARY = "Hand selected linux firmware binary blobs for Gateworks SBC's"
SECTION = "kernel"

# Choosing proprietary license because licenses differ per firmware binary
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://LICENCE.iwlwifi_firmware;md5=3fd842911ea93c29cd32679aa23e1c88 \
                    file://LICENCE.ibt_firmware;md5=fdbee1ddfe0fb7ab0b2fcd6b454a366b \
                    file://LICENCE.atheros_firmware;md5=30a14c7823beedac9fa39c64fdd01a13 \
                   "

inherit allarch

SRCREV = "ade8332383e228cbdcfc605b5e5ef3aa51211401"
PE = "20170422"
PV = "0.1+git${SRCPV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/firmware/linux-firmware.git"

S = "${WORKDIR}/git"

# Firmware to install onto rootfs + any licenses
INSTALL_FW = "ar3k/*.dfu intel/*.bseq iwlwifi-7260-*.ucode \
              LICENCE.atheros_firmware LICENCE.ibt_firmware LICENCE.iwlwifi_firmware"

do_compile() {
    :
}

do_configure() {
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