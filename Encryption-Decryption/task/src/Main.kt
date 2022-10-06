package tictactoe

fun main() {
    val orgMessage = "we found a treasure!"
    println(smpEncrypt(orgMessage))
}

fun smpEncrypt(org: String): String {
    var retStr: String = ""
    val diff = 'z'.code - 'a'.code
    org.toCharArray().forEach {
        if(it in 'a'..'z') {
            var chr = it.code - diff
            if(chr < 'a'.code) chr = 'a'.code + ('a'.code - chr)
            retStr += chr.toChar()
        } else {
            retStr += it.toChar()
        }
    }
    return retStr
}