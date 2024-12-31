import java.io.File

fun day3() {
    val file = File("input_day3.txt")
    val regexMul = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")
    val regexDo = Regex("""do\(\)""")
    val regexDont = Regex("""don't\(\)""")
    var totalSum = 0
    var enabled = true
    for (line in file.readLines()) {
        val matches = mutableListOf<Pair<MatchResult, String>>()
        matches.addAll(regexMul.findAll(line).map {it to "mul" })
        matches.addAll(regexDo.findAll(line).map {it to "do" })
        matches.addAll(regexDont.findAll(line).map { it to "dont"})
        matches.sortBy { it.first.range.first }
        for ((ok, word) in matches) {
            when (word) {
                "do" -> enabled = true
                "dont" -> enabled = false
                "mul" -> if (enabled) {
                    val first = ok.groupValues[1].toInt()
                    val second = ok.groupValues[2].toInt()
                    totalSum += first * second
                }
            }
        }
    }
    println(totalSum)
}

fun main() {
    day3()
}