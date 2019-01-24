DESCRIPTION = "Gateworks GStreamer Sample Applications"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=3000208d539ec061b899bce1d9ce9404"

DEPENDS += " \
    gstreamer1.0 \
    gstreamer1.0-rtsp-server \
    gstreamer1.0-plugins-imx \
"

PR = "r3"

PV = "1.4+${SRCPV}"
SRC_BRANCH = "master"
SRCREV = "f4c2a4ba2100958eaee9bdbb133cfe22846c707d"
SRC_URI = "git://github.com/Gateworks/gst-gateworks-apps;protocol=git;branch=${SRC_BRANCH}"

S = "${WORKDIR}/git"
DESTDIR = "/usr/bin"

inherit pkgconfig

do_compile() {
    make
}

do_install() {
    # Copy all files in 'bin' to /usr/bin/
    install -d ${D}${DESTDIR}
    for f in $(find ${S}/bin/ -type f); do
        install -m 0755 ${f} ${D}${DESTDIR}
    done
}

COMPATIBLE_MACHINE = "(mx6)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
