fun main() {
    // write your code here
    val instr = readln()
    doublechar(instr, "2".toInt())
}

fun doublechar(str: String, counter: Int) {
    str.toCharArray().forEach {
        val itt = it
        repeat(counter) {
            print(itt)
        }
    }
}