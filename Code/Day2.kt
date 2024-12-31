import java.io.File

fun day2() {
    val file = File("input_day2.txt")
    var totalSafe = 0
    for (line in file.readLines()) {
        val parts = line.split(" ").map { it.toInt() }
        var safe = true
        var secondSafe = true
        var upDiff = false
        var downDiff = false
        for (i in 0 until parts.size-1) {
            if (parts[i] < parts[i+1]) {
                upDiff = true
            } else if (parts[i] > parts[i+1]) {
                downDiff = true
            }
            if ((parts[i] == parts[i+1])||(upDiff && downDiff) ||
                (Math.abs(parts[i] - parts[i+1]) !in 1..3)) {
                safe = false
                break
            }
        }
        if (!safe) {
            for (j in parts.indices) {
                val newParts = parts.toMutableList()
                newParts.removeAt(j)
                secondSafe = true
                upDiff = false
                downDiff = false
                for (k in 0 until newParts.size-1) {
                    if (newParts[k] < newParts[k+1]) {
                        upDiff = true
                    } else if (newParts[k] > newParts[k+1]) {
                        downDiff = true
                    }
                    if ((newParts[k] == newParts[k+1]) || (upDiff && downDiff) ||
                        (Math.abs(newParts[k]-newParts[k+1]) !in 1..3)) {
                        secondSafe = false
                        break
                    }
                }
                if (secondSafe) {
                    break
                }
            }
        }
        if (safe||secondSafe) {
            totalSafe++
        }
    }
    println(totalSafe)
}

fun main() {
    day2()
}