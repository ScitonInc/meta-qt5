require qt5.inc
require qt5-git.inc

LICENSE = "(GPL-3.0 & BSD) | The-Qt-Company-Commercial"
LIC_FILES_CHKSUM = " \
    file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
"

DEPENDS += "qtbase qtdeclarative qtquickcontrols2"

SRC_URI += " \
    git://github.com/assimp/assimp.git;name=assimp;branch=assimp_5.0_release;protocol=https;destsuffix=git/src/3rdparty/assimp/src \
"

PACKAGECONFIG ??= ""
PACKAGECONFIG[system-assimp] = "-system-assimp,-qt-assimp,assimp"

EXTRA_QMAKEVARS_CONFIGURE += "${PACKAGECONFIG_CONFARGS}"

FILES_${PN}-qmlplugins += " \
  ${OE_QMAKE_PATH_QML}/QtQuick3D/Helpers/meshes/*.mesh \
"

SRCREV_qtquick3d = "5cbcc4f38aa08026d45eff75f2612c6243f0d3f7"
SRCREV_assimp = "8f0c6b04b2257a520aaab38421b2e090204b69df"

SRCREV_FORMAT = "qtquick3d_assimp"
