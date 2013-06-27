FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PRINC := "${@int(PRINC) + 12}"

COMPATIBLE_MACHINE = "(mx6)"

# Revision of 1.1.0 tag
SRCREV = "c27cb3851bb6f822f8a92e4a1e10fba19284bdd4"
LOCALVERSION = "-1.1.0+yocto"

SRC_URI += " \
            file://0001-Support-BT656-and-BT1120-output-for-iMX6-ipuv3.patch \
            file://0002-Support-adv739x-TV-encoder-for-BT656-output.patch \
           "

# iMX6Q Ventana changes done by Gateworks
SRC_URI_append_ventana = " file://gateworks_ventana.patch"
