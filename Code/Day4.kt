import java.io.File

fun day4() {
    val file = File("input_day4.txt")
    val word = "XMAS"
    var totalXMAS = 0
    val lines = file.readLines()
    val rows = lines.size
    val cols = lines[0].length

    for (row in 0 until rows) {
        for (col in 0 until cols) {
            if (lines[row][col] == word[0]) {
                if (row-3 >= 0 && lines[row-1][col] == word[1] && lines[row-2][col] == word[2] && lines[row-3][col] == word[3]
                ) {
                    totalXMAS++
                }
                if (row+3 < rows && lines[row+1][col] == word[1] && lines[row+2][col] == word[2] && lines[row + 3][col] == word[3]
                ) {
                    totalXMAS++
                }
                if (col-3 >= 0 && lines[row][col-1] == word[1] && lines[row][col-2] == word[2] && lines[row][col-3] == word[3]
                ) {
                    totalXMAS++
                }
                if (col+3 < cols && lines[row][col+1] == word[1] && lines[row][col+2] == word[2] && lines[row][col+3] == word[3]
                ) {
                    totalXMAS++
                }
                if (row-3 >= 0 && col-3 >= 0 && lines[row-1][col-1] == word[1] && lines[row-2][col-2] == word[2] && lines[row-3][col-3] == word[3]
                ) {
                    totalXMAS++
                }
                if (row+3 < rows && col+3 < cols && lines[row+1][col+1] == word[1] && lines[row+2][col+2] == word[2] && lines[row+3][col+3] == word[3]
                ) {
                    totalXMAS++
                }
                if (row-3 >= 0 && col+3 < cols && lines[row-1][col+1] == word[1] && lines[row-2][col+2] == word[2] && lines[row-3][col+3] == word[3]
                ) {
                    totalXMAS++
                }
                if (row+3 < rows && col-3 >= 0 && lines[row+1][col-1] == word[1] && lines[row+2][col-2] == word[2] && lines[row+3][col-3] == word[3]
                ) {
                    totalXMAS++
                }
            }
        }
    }
    println(totalXMAS)
}

fun day4PartTwo() {
    val file = File("input_day4.txt")
    var totalXMAS = 0
    val word = "XMAS"
    val lines = file.readLines()
    val rows = lines.size
    val cols = lines[0].length
    for (row in 0 until rows) {
        for (col in 0 until cols) {
            val grid = row+2 < rows && col+2 < cols
            if (grid && ((lines[row][col] == word[1] && lines[row+1][col+1] == word[2] && lines[row+2][col+2] == word[3])||
                (lines[row][col] == word[3] && lines[row+1][col+1] == word[2] && lines[row+2][col+2] == word[1]))) {
                if(lines[row+2][col] == word[1] && lines[row][col+2] == word[3]) {
                    totalXMAS++
                } else if (lines[row+2][col] == word[3] && lines[row][col+2] == word[1]) {
                    totalXMAS++
                }
            }
        }
    }
    println(totalXMAS)
}

fun main() {
    day4()
    day4PartTwo()
}