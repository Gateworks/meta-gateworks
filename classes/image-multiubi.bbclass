IMAGE_DEPENDS_multiubi = "mtd-utils-native"
IMAGE_TYPES += "multiubi"

# $1 - mkubifs args
# $2 - ubinize_args
# $3 - volume name (optional)
multiubi_mkfs() {
    local mkubifs_args="$1"
    local ubinize_args="$2"
    local vname="$3"

    echo \[ubifs\] > ubinize${vname:+_${vname}}.cfg
    echo mode=ubi >> ubinize${vname:+_${vname}}.cfg
    echo image=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${vname:+_${vname}}.rootfs.ubifs >> ubinize${vname:+_${vname}}.cfg
    echo vol_id=0 >> ubinize${vname:+_${vname}}.cfg
    echo vol_type=dynamic >> ubinize${vname:+_${vname}}.cfg
    echo vol_name=${UBI_VOLNAME:-rootfs} >> ubinize${vname:+_${vname}}.cfg
    echo vol_flags=autoresize >> ubinize${vname:+_${vname}}.cfg
    mkfs.ubifs -r ${IMAGE_ROOTFS} -o ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${vname:+_${vname}}.rootfs.ubifs ${mkubifs_args}
    ubinize -o ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${vname:+_${vname}}.rootfs.ubi ${ubinize_args} ubinize${vname:+_${vname}}.cfg

    # Create own symlink
    cd ${DEPLOY_DIR_IMAGE}
    if [ -e ${IMAGE_NAME}${vname:+_${vname}}.rootfs.ubi ]; then
        ln -sf ${IMAGE_NAME}${vname:+_${vname}}.rootfs.ubi \
            ${IMAGE_LINK_NAME}${vname:+_${vname}}.ubi
    fi
    cd -
}

IMAGE_CMD_multiubi() {
    # Split MKUBIFS_ARGS_<name> and UBINIZE_ARGS_<name> and UBI_VOLNAME_<name>
    for name in ${MULTIUBI_BUILD}; do
        eval local mkubifs_args=\"\$MKUBIFS_ARGS_${name}\"
        eval local ubinize_args=\"\$UBINIZE_ARGS_${name}\"

        multiubi_mkfs "${mkubifs_args}" "${ubinize_args}" "${name}"
    done
}
