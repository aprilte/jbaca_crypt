package tictactoe

import java.io.File
import java.lang.Exception

fun main(args: Array<String>) {
    var mode: String = "enc"
    var key: Int = 0
    var alg: String = "shift"
    var data: String = ""
    var outputFile: String = ""
    var inDataFile: String = ""

    args.withIndex().forEach {
        if (it.value == "-mode") mode = args[it.index + 1]
        if (it.value == "-key") key = args[it.index + 1].toInt() ?: 0
        if (it.value == "-data") data = args[it.index + 1]
        if (it.value == "-out") outputFile = args[it.index + 1]
        if (it.value == "-in") inDataFile = args[it.index + 1]
        if (it.value == "-alg") alg = args[it.index + 1]
    }
    if (inDataFile != "" && data != "") inDataFile = ""

    val cyp = smpCyp(key, data, inDataFile, outputFile, alg)
    if (inDataFile != "") {
        cyp.readFileData()
    }

    if (mode == "enc") {
        cyp.smpEncrypt(cyp.restrict)
    } else {
        cyp.smpDecrypt(cyp.restrict)
    }
    println(cyp.processedData)

    if (outputFile != "") {
        cyp.writeFileData()
    }

}

class smpCyp(_key: Int, _data: String, _inFile: String, _outFile: String, _restr: String) {
    var cypKey = _key
    var data = _data
    val inFile = _inFile
    val outFile = _outFile
    var processedData = ""
    val restrict = (_restr == "shift")

    fun readFileData() {
        try {
            val file = File(inFile)
            this.data = file.readText()
            println("input::: ${this.data}")
        } catch (ex: Exception) {
            println("Input File Stream Error")
        } finally {
        }
    }

    fun writeFileData() {
        try {
            val file = File(outFile)
            file.writeText(processedData)
        } catch (ex: Exception) {
            println("Output File Stream Error")
        }
    }

    fun smpEncrypt(restrict: Boolean) {
        var retStr: String = ""
        data.toCharArray().forEach {
            if (restrict) {
                var chr = 0
                if (it in 'a'..'z' || it in 'A'..'Z') {
                    if (it in 'A'..'Z') {
                        chr = it.code + cypKey
                        if ('Z'.code < chr) chr = 'A'.code + (chr - ('Z'.code + 1))
                    } else {
                        chr = it.code + cypKey
                        if ('z'.code < chr) chr = 'a'.code + (chr - ('z'.code + 1))
                    }
                    retStr += chr.toChar()
                } else {
                    retStr += it.toChar()
                }
            } else {
                //unicode mode
                retStr += (it.code + cypKey).toChar()
            }
        }
        processedData = retStr
        println("Encoded::" + processedData)
    }

    fun smpDecrypt(restrict: Boolean) {
        var retStr: String = ""
        data.toCharArray().forEach {
            if (restrict) {
                var chr = 0
                if (it in 'a'..'z' || it in 'A'..'Z') {
                    if (it in 'A'..'Z') {
                        chr = it.code - cypKey
                        if (chr < 'A'.code) chr = 'Z'.code - ('A'.code - chr - 1)
                    } else {
                        chr = it.code - cypKey
                        if (chr < 'a'.code) chr = 'z'.code - ('a'.code - chr - 1)
                    }
                    retStr += chr.toChar()
                } else {
                    retStr += it.toChar()
                }
            } else {
                //unicode mode
                retStr += (it.code - cypKey).toChar()
            }
        }
        processedData = retStr
        println("Decoded::" + processedData)
    }


}
