# This will disable gpsd from starting on boot via sysvinit
# Please see update-rc.d.bbclass for more information
INITSCRIPT_PARAMS = "stop 35 0 1 6 ."
