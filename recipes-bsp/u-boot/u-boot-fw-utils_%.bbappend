#
# The boot device on Ventana boards vary between NAND flash and microSD/eMMC.
# Therefore we will use a postinst script to detect at install time the
# presence of NAND flash and install the correct /etc/fw_env.config file
#
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

pkg_postinst_${PN}() {
#!/bin/sh -e

if [ x"$D" = "x" ]; then # Only run on boot time
    cd ${sysconfdir}
    if [ -c /dev/mtd1 ]; then
         cat << EOF > "${sysconfdir}/fw_env.config"
# NAND Flash
# MTD device name       Device offset   Env. size       Flash sector size      Number of sectors
/dev/mtd1               0x00000         0x20000         0x40000
/dev/mtd1               0x80000         0x20000         0x40000
EOF
    else
         cat << EOF > "${sysconfdir}/fw_env.config"
# microSD/MMC
# MTD device name       Device offset   Env. size       Flash sector size      Number of sectors
/dev/mmcblk0            0xb1400         0x20000         0x20000
/dev/mmcblk0            0xd1400         0x20000         0x20000
EOF
    fi
else
    exit 1
fi
}

COMPATIBLE_MACHINE = "(ventana)"
