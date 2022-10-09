fun main() {
    // put your code here
    val spaces = space()
    var p1 = readln().split(" ")
    spaces.set(p1[1].toInt(), p1[0].toInt())

    p1 = readln().split(" ")
    spaces.set(p1[1].toInt(), p1[0].toInt())

    p1 = readln().split(" ")
    spaces.set(p1[1].toInt(), p1[0].toInt())

    spaces.chkVacant()
    spaces.printv()

}

class space {
    val field = List<Int>(25) { 0 }.toMutableList()
    var vx = arrayListOf<Int>()
    var vy = arrayListOf<Int>()

    fun set(x: Int, y: Int) {
        val point = (x - 1) * 5 + (y - 1)
        field[point] = 1
    }

    fun printv() {
        println(vx.joinToString(" "))
        println(vy.joinToString(" "))
    }

    fun printx() {
        field.withIndex().forEach {
            print("${it.value} ")
            if ((it.index + 1) % 5 == 0) {
                println(".")
            }
        }
    }

    fun chkVacant() {
        var chk = 0
        var idx = 0
        field.withIndex().forEach {
            chk += it.value
            if ((it.index + 1) % 5 == 0) {
                if (chk == 0) {
                    vy.add((it.index + 1) / 5)
                }
                chk = 0
            }
        }
        chk = 0
        for (i in 0..4) {
            for (j in 0..4) {
               chk += field[(j * 5)+(i)]
               if (j == 4) {
                   if (chk == 0) vx.add((i + 1))
               }
            }
            chk = 0
        }
    }

}