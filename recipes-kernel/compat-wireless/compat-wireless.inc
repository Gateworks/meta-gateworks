DESCRIPTION = "Latest wireless drivers"
HOMEPAGE = "http://wireless.kernel.org/en/users/Download"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
RDEPENDS_${PN} = "wireless-tools ath10k-firmware"
INC_PR = "r1"

# depends on config options which are not enabled in qemu* MACHINEs by default
# config.mk:25: *** "ERROR: your kernel has CONFIG_CFG80211=y, you should have it CONFIG_CFG80211=m if you want to use this thing.".  Stop.
EXCLUDE_FROM_WORLD = "1"

SRC_URI = "\
	file://0001-disable_kconf.patch \
	file://0002-define_reinit.patch \
	file://0003-add-KLIB_CONFIG.patch \
"

COMPAT_WIRELESS_VERSION = "${PV}-1"
SHRT_VER = "${@d.getVar('PV',1).split('.')[0]}.${@d.getVar('PV',1).split('.')[1]}"

S = "${WORKDIR}/compat-wireless-${COMPAT_WIRELESS_VERSION}"

inherit module

EXTRA_OEMAKE = "KLIB_BUILD=${STAGING_KERNEL_DIR} KLIB_CONFIG=${STAGING_KERNEL_BUILDDIR} KLIB=${D}"

do_configure_prepend() {
    cp ${WORKDIR}/defconfig ${S}/.config
}

do_install() {
    make -C ${STAGING_KERNEL_DIR} M=${S} INSTALL_MOD_PATH=${D} modules_install
}

# Override do_packagedata() function (was empty otherwise) in order to
# dynamically add split kernel-modules created by this package into the
# SSTATE_DUPWHITELIST variable so as to allow these modules to overwrite those
# created by the kernel.
python do_packagedata() {
    # Python function that returns packages that were split from this main package
    def get_split_modules(d, prepend=""):
        split_dir = d.getVar('PKGDEST', True)
        split_files = ""
        for mod in os.listdir(split_dir):
            if "kernel-module" in str(mod):
                split_files += " " + str(prepend) + str(mod)

        return str(split_files)

    def pop_whitelist(d):
        runtime_vars = get_split_modules(d, d.getVar('PKGDATA_DIR', True) + '/runtime/')
        reverse_vars = get_split_modules(d, d.getVar('PKGDATA_DIR', True) + '/runtime-reverse/')

        # Add to duplicate files whitelist these specific kernel modules (full path req'd)
        d.setVar('SSTATE_DUPWHITELIST', d.getVar('SSTATE_DUPWHITELIST', True) + " " + runtime_vars)
        d.setVar('SSTATE_DUPWHITELIST', d.getVar('SSTATE_DUPWHITELIST', True) + " " + reverse_vars)

    pop_whitelist(d)
}
