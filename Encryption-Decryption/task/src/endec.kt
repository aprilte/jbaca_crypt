package tictactoe

fun smpEncrypt(org: String, shift: Int): String {
    var retStr: String = ""
    val diff = shift
    org.toCharArray().forEach {
        if (true) {
            var chr = it.code + diff
            retStr += chr.toChar()
        } else {
            retStr += it.toChar()
        }
    }
    return retStr
}

fun smpDecrypt(msg: String, shift: Int): String {
    var retStr: String = ""
    msg.toCharArray().forEach {
        if (true) {
            var chr = it.code - shift
            retStr += chr.toChar()
        } else {
            retStr += it.toChar()
        }
    }
    return retStr
}