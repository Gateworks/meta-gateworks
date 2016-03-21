DESCRIPTION = "Ath10k 802.11ac driver firmware"
HOMEPAGE = "http://wireless.kernel.org/en/users/Drivers/ath10k/firmware"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://LICENSE.qca_firmware;md5=2a397c0e988f4c52d3d526133b617c8d"

PR = "r1"

SRCREV = "9fffffd697597d023dc9ae37dac3c0bb3af2cf34"
LOCALVERSION = "-g9fffffd6"
SRC_URI = "git://github.com/kvalo/ath10k-firmware;protocol=http;branch=master"

FW_DIR = "firmware/ath10k"

QCA6174_2_1_FW_FILE = "firmware-5.bin_SW_RM.1.1.1-00157-QCARMSWPZ-1"
QCA6174_3_0_FW_FILE = "firmware-4.bin_WLAN.RM.2.0-00180-QCARMSWPZ-1"

QCA988X_2_0_FW_DIR  = "10.2.4"
QCA988X_2_0_FW_FILE = "firmware-5.bin_10.2.4.70.31-2"

QCA99X0_2_0_BOARD_FILE = "boardData_AR900B_CUS260_2G_v2_002.bin"
QCA99X0_2_0_FW_FILE    = "firmware-5.bin_10.4.1.00030-1"

S = "${WORKDIR}/git"

inherit allarch

do_configure() {
    :
}

do_compile() {
    :
}

do_install() {
    ## Install QCA6174
    install -d ${D}${base_libdir}/${FW_DIR}/QCA6174/hw2.1
    install -d ${D}${base_libdir}/${FW_DIR}/QCA6174/hw3.0
    # Install board files
    install -m 0644 ${S}/QCA6174/hw2.1/board.bin ${D}${base_libdir}/${FW_DIR}/QCA6174/hw2.1/
    install -m 0644 ${S}/QCA6174/hw2.1/board-2.bin ${D}${base_libdir}/${FW_DIR}/QCA6174/hw2.1/
    install -m 0644 ${S}/QCA6174/hw3.0/board.bin ${D}${base_libdir}/${FW_DIR}/QCA6174/hw3.0/
    install -m 0644 ${S}/QCA6174/hw3.0/board-2.bin ${D}${base_libdir}/${FW_DIR}/QCA6174/hw3.0/
    # Install firmware
    install -m 0644 ${S}/QCA6174/hw2.1/${QCA6174_2_1_FW_FILE} ${D}${base_libdir}/${FW_DIR}/QCA6174/hw2.1/
    install -m 0644 ${S}/QCA6174/hw3.0/${QCA6174_3_0_FW_FILE} ${D}${base_libdir}/${FW_DIR}/QCA6174/hw3.0/
    ln -sf ${QCA6174_2_1_FW_FILE} ${D}/${base_libdir}/${FW_DIR}/QCA6174/hw2.1/firmware-5.bin
    ln -sf ${QCA6174_3_0_FW_FILE} ${D}/${base_libdir}/${FW_DIR}/QCA6174/hw3.0/firmware-4.bin

    ## Install QCA988X
    install -d ${D}${base_libdir}/${FW_DIR}/QCA988X/hw2.0/
    # Install board file
    install -m 0644 ${S}/QCA988X/board.bin ${D}${base_libdir}/${FW_DIR}/QCA988X/hw2.0/
    # Install firmware
    install -m 0644 ${S}/QCA988X/${QCA988X_2_0_FW_DIR}/${QCA988X_2_0_FW_FILE} ${D}${base_libdir}/${FW_DIR}/QCA988X/hw2.0/
    ln -sf ${QCA988X_2_0_FW_FILE} ${D}/${base_libdir}/${FW_DIR}/QCA988X/hw2.0/firmware-5.bin

    ## Install QCA99X0
    install -d ${D}${base_libdir}/${FW_DIR}/QCA99X0/hw2.0/
    # Install board file
    install -m 0644 ${S}/QCA99X0/hw2.0/${QCA99X0_2_0_BOARD_FILE} ${D}${base_libdir}/${FW_DIR}/QCA99X0/hw2.0/
    ln -sf ${QCA99X0_2_0_BOARD_FILE} ${D}/${base_libdir}/${FW_DIR}/QCA99X0/hw2.0/board.bin
    # Install firmware
    install -m 0644 ${S}/QCA99X0/hw2.0/${QCA99X0_2_0_FW_FILE} ${D}${base_libdir}/${FW_DIR}/QCA99X0/hw2.0/
    ln -sf ${QCA99X0_2_0_FW_FILE} ${D}/${base_libdir}/${FW_DIR}/QCA99X0/hw2.0/firmware5.bin
}

PACKAGES = "${PN}"
FILES_${PN} = "${base_libdir}/${FW_DIR}"
