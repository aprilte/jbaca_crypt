fun main() {
    val numbers = List<Int>(100) {
        when {
            it == 0 -> 1
            it == 9 -> 10
            it == 99 -> 100
            else -> 0
        }
    }

    // do not touch the lines below
    println(numbers.joinToString())
}