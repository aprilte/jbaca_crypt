package tictactoe

fun main(args: Array<String>) {
    var mode: String = "enc"
    var key: Int = 0
    var data: String = ""

    args.withIndex().forEach {
        if(it.value == "-mode") mode = args[it.index + 1]
        if(it.value == "-key") key = args[it.index + 1].toInt() ?: 0
        if(it.value == "-data") data = args[it.index + 1]
    }

    if (mode == "enc") {
        println(smpEncrypt(data, key))
    } else {
        println(smpDecrypt(data, key))
    }
}
