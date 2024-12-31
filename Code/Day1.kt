import java.io.File

fun Day1() {
    val file = File("input_day1.txt")
    val leftArray = mutableListOf<Int>()
    val rightArray = mutableListOf<Int>()
    var totalDistance = 0
    var toralSimilarity = 0
    for (line in file.readLines()) {
        var left = line.substringBefore(" ").toInt()
        var right = line.substringAfter(" ").trim().toInt()
        leftArray.add(left)
        rightArray.add(right)

    }
    val sortedLeft = leftArray.sorted()
    val sortedRight = rightArray.sorted()
    for (i in 0 until leftArray.size) {
        if (sortedLeft[i] > sortedRight[i]) {
            totalDistance += sortedLeft[i]-sortedRight[i]
        } else {
            totalDistance += sortedRight[i]-sortedLeft[i]
        }
    }
    var similarity = 0
    for (i in 0 until sortedLeft.size) {
        for (j in 0 until sortedRight.size) {
            if (sortedLeft[i] == sortedRight[j]) {
                similarity++
            }
        }
        toralSimilarity += (sortedLeft[i]*similarity)
        similarity = 0

    }
    println(totalDistance)
    println(toralSimilarity)
}

fun main() {
    Day1()
}