package tictactoe

fun main() {
    val select = readln()
    val orgMessage = readln()
    val encNum = readln().toInt()
    if (select == "enc") {
        println(smpEncrypt(orgMessage, encNum))
    } else {
        println(smpDecrypt(orgMessage, encNum))
    }
}

fun smpEncrypt(org: String, shift: Int): String {
    var retStr: String = ""
    val diff = shift
    org.toCharArray().forEach {
        if (true) {
            var chr = it.code + diff
//            if ('z'.code < chr) chr = 'a'.code + (chr - ('z'.code + 1))
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
//            if (chr < 'a'.code) chr = 'z'.code - ('a'.code - chr - 1)
            retStr += chr.toChar()
        } else {
            retStr += it.toChar()
        }
    }
    return retStr
}