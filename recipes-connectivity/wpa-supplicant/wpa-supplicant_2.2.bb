require wpa-supplicant.inc

SRC_URI = "git://w1.fi/hostap.git \
	file://defconfig-gnutls \
	file://wpa-supplicant.sh \
	file://wpa_supplicant.conf \
	file://wpa_supplicant.conf-sane \
	file://99_wpa_supplicant \
	file://fix-libnl3-host-contamination.patch \
"

SRCREV = "4e0a94b7dc76db58cddbbcfe0be0bfef547f6dd0"
LOCALVERSION = "-g4e0a94b"

S = "${WORKDIR}/git"

SRC_URI[md5sum] = "238e8e888bbd558e1a57e3eb28d1dd07"
SRC_URI[sha256sum] = "e0d8b8fd68a659636eaba246bb2caacbf53d22d53b2b6b90eb4b4fef0993c8ed"
