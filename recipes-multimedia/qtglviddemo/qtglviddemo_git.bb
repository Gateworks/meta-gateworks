DESCRIPTION = "A Qt 5 demo application for rendering videos on 3D objects integrated in QtQuick 2."
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
SECTION = "graphics"
DEPENDS = "udev qtbase qtdeclarative qtquickcontrols2 glib-2.0 gstreamer1.0 gstreamer1.0-plugins-bad gstreamer1.0-plugins-base"
RDEPENDS_${PN}-mx6 = "gstreamer1.0-plugins-imx-imxv4l2video gstreamer1.0-plugins-imx-imxvpu"

inherit qmake5

SRC_URI = "git://github.com/dv1/qtglviddemo.git;branch=master \
           file://gwlogo_2400.png \
           file://qtglviddemo.cfg \
"
SRCREV = "751fa144814e8d61f1ddc18953e5f2388897c159"

S = "${WORKDIR}/git"

PV = "1.0+git${SRCPV}"

EXTRA_PLATFORM_CONFIG ?= ""
EXTRA_PLATFORM_CONFIG_mx6 = "CONFIG+=vivante CONFIG+=useImxV4L2"

EXTRA_QMAKEVARS_PRE = " \
        PREFIX=${prefix} \
        ${EXTRA_PLATFORM_CONFIG} \
"
EXTRA_OEMAKE += "INSTALL_ROOT=${D}"

install_extra_files() {
        install -d ${D}${sysconfdir}
        install -m 0644 ${WORKDIR}/qtglviddemo.cfg ${D}${sysconfdir}
        install -d ${D}${datadir}/qtglviddemo
        install -m 0644 ${WORKDIR}/gwlogo_2400.png ${D}${datadir}/qtglviddemo
}

do_install[postfuncs] += " install_extra_files "

FILES_${PN} += "${datadir}/qtglviddemo/gwlogo_2400.png ${sysconfdir}/qtglviddemo.cfg"
