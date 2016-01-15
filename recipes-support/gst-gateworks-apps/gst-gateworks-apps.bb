DESCRIPTION = "Gateworks GStreamer Sample Applications"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS += " \
    gstreamer1.0 \
    gstreamer1.0-rtsp-server \
    gstreamer1.0-plugins-imx \
"

PR = "r2"

PV = "1.4+${SRCPV}"
SRC_BRANCH = "master"
SRCREV = "490564815d8049dbdd79087f546835b673ba6e88"
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
