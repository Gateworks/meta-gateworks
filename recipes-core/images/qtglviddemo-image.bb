LICENSE = "MIT"

IMAGE_FEATURES += "ssh-server-dropbear package-management splash"

inherit core-image

COMMON_IMX_PACKAGES = " \
        fsl-alsa-plugins \
        imx-codec \
        imx-codec-aac \
        imx-codec-bmp \
        imx-codec-bsac \
        imx-codec-flac \
        imx-codec-g.711 \
        imx-codec-g.723.1 \
        imx-codec-g.726 \
        imx-codec-g.729ab \
        imx-codec-gif \
        imx-codec-h264 \
        imx-codec-jpeg \
        imx-codec-meta \
        imx-codec-mp3 \
        imx-codec-mpeg2 \
        imx-codec-mpeg4asp \
        imx-codec-nb \
        imx-codec-oggvorbis \
        imx-codec-peq \
        imx-codec-png \
        imx-codec-sbc \
        imx-codec-src \
        imx-codec-wb \
        imx-parser \
        firmware-imx \
        gstreamer1.0-plugins-imx-meta \
"
COMMON_MX6_PACKAGES = " \
        ${COMMON_IMX_PACKAGES} \
        imx-gpu-viv \
        imx-gpu-viv-g2d \
        libgles-mx6 \
        libgles2-mx6 \
        libglslc-mx6 \
        libopenvg-mx6 \
        libvivante-mx6 \
        libegl-mx6 \
        libgal-mx6 \
        libopencl-mx6 \
        libclc-mx6 \
"

PLATFORM_PACKAGES ?= ""
PLATFORM_PACKAGES_mx6dl = " \
        ${COMMON_MX6_PACKAGES} \
        libimxvpuapi \
"
PLATFORM_PACKAGES_mx6q = "${PLATFORM_PACKAGES_mx6dl}"
PLATFORM_PACKAGES_mx6sx = "${COMMON_MX6_PACKAGES}"
PLATFORM_PACKAGES_mx7 = " \
        ${COMMON_IMX_PACKAGES} \
"

GST_PACKAGES = " \
        gstreamer1.0 \
        gstreamer1.0-plugins-base-meta \
        gstreamer1.0-plugins-good-meta \
        gstreamer1.0-plugins-bad-meta \
        gstreamer1.0-plugins-ugly-meta \
        gstreamer1.0-libav \
        gstreamer1.0-rtsp-server \
"

QT5_PACKAGES = " \
        qtbase \
        qtbase-plugins \
        qtdeclarative \
        qtdeclarative-plugins \
        qtdeclarative-qmlplugins \
        qtimageformats \
        qtimageformats-plugins \
        qtdeclarative-tools \
        qtgraphicaleffects-qmlplugins \
        qtquickcontrols-qmlplugins \
        qtquickcontrols2-qmlplugins \
"

EXTRA_PACKAGES = " \
        v4l-utils \
        htop \
        liberation-fonts \
        packagegroup-fonts-truetype \
        fontconfig \
        hicolor-icon-theme \
        adwaita-icon-theme \
        qtglviddemo \
"

CORE_IMAGE_EXTRA_INSTALL += " ${GST_PACKAGES} ${PLATFORM_PACKAGES} ${QT5_PACKAGES} ${EXTRA_PACKAGES} "
