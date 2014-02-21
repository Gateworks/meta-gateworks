# Handle ubi configs for a machine
#
# The format to specify it, in the machine, is:
#
# UBI_CONFIG ??= <default>
# UBI_CONFIG_MKUBIFS[foo] = "F -m 2048 -e 124KiB -c 1912 -x zlib"
# UBI_CONFIG_UBINIZE[foo] = "-m 2048 -p 128KiB -s 2048"
#
# or
#
# MKUBIFS_ARGS += "-F -m 2048 -e 124KiB -c 1912 -x zlib"
# UBINIZE_ARGS += "-m 2048 -p 128KiB -s 2048"
#

python () {
    mkubifs = d.getVar("MKUBIFS_ARGS", True)
    ubinize = d.getVarFlags('UBINIZE_ARGS')
    mkubifsconfig = d.getVarFlags('UBI_CONFIG_MKUBIFS')
    ubinizeconfig = d.getVarFlags('UBI_CONFIG_UBINIZE')

    if not mkubifs and not ubinize and not mkubifsconfig and not ubinizeconfig:
        PN = d.getVar("PN", True)
        FILE = os.path.basename(d.getVar("FILE", True))
        bb.debug(1, "To build %s, see %s for instructions on \
                 setting up your machine config" % (PN, FILE))
        raise bb.parse.SkipPackage("Either MKUBIFS_ARGS/UBINIZE_ARGS or UBI_CONFIG_MKUBIFS/UBI_CONFIG_UBINIZE must be set in the %s machine configuration." % d.getVar("MACHINE", True))

    if mkubifs and ubinize and mkubifsconfig and ubinizeconfig:
        raise bb.parse.SkipPackage("You cannot use MKUBIFS_ARGS/UBINIZE_ARGS and UBI_CONFIG_MKUBIFS/UBI_CONFIG_UBINIZE at the same time.")
       
    if not mkubifsconfig and not ubinizeconfig:
        return

    ubiconfig = (d.getVar('UBI_CONFIG', True) or "").split()
    if len(ubiconfig) > 1:
        raise bb.parse.SkipPackage('You can only have a single default for UBI_CONFIG.')
    elif len(ubiconfig) == 0:
        raise bb.parse.SkipPackage('You must set a default in UBI_CONFIG.')
    ubiconfig = ubiconfig[0]

    for f, v in mkubifsconfig.items():
        if f == 'defaultval':
            continue

        if ubiconfig == f:
            bb.debug(1, "Setting MKUBIFS_ARGS to %s." % v)
            d.setVar('MKUBIFS_ARGS', v);
            d.appendVar('IMAGE_NAME', "_%s" % f)
            d.appendVar('IMAGE_LINK_NAME', "_%s" % f)
            break;

    else:
        raise ValueError("UBI_CONFIG %s is not supported" % ubiconfig)

    for f, v in ubinizeconfig.items():
        if f == 'defaultval':
            continue

        if ubiconfig == f:
            bb.debug(1, "Setting UBINIZE_ARGS to %s." % v)
            d.setVar('UBINIZE_ARGS', v);
            break;

    else:
        raise ValueError("UBI_CONFIG %s is not supported" % ubiconfig)
}
