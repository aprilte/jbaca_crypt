fun main() {
    // write your code here
    val ina = readln().lowercase()
    ganc(ina)
}

fun ganc(str: String) {
    val len = str.length
    val gc = str.length - str.replace("g", "").length + (str.length - str.replace("c", "").length)
    println(gc.toDouble() / len * 100.0)
}
