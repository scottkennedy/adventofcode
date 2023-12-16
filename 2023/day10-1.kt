fun main() {
    val caseInput = input
    val lines = caseInput.lines()

    val map = lines.map { it.toCharArray().toList() }

    val startRow = map.indexOfFirst { it.contains('S') }
    val startCol = map[startRow].indexOf('S')

    val visited = mutableSetOf(startRow to startCol)

    var currentRow = startRow
    var currentCol = startCol

    if (currentRow > 0 && map[currentRow - 1][currentCol] == '|') {
        currentRow -= 1
    } else if (currentRow < map.lastIndex && map[currentRow + 1][currentCol] == '|') {
        currentRow += 1
    } else if (currentCol > 0 && map[currentRow][currentCol - 1] == '-') {
        currentCol -= 1
    } else if (currentCol < map.first().lastIndex && map[currentRow][currentCol + 1] == '-') {
        currentCol += 1
    } else if (currentRow > 0 && map[currentRow - 1][currentCol] == 'L') {
        currentRow -= 1
    } else if (currentCol < map.first().lastIndex && map[currentRow][currentCol + 1] == 'L') {
        currentCol += 1
    } else if (currentRow > 0 && map[currentRow - 1][currentCol] == 'J') {
        currentRow -= 1
    } else if (currentCol > 0 && map[currentRow][currentCol - 1] == 'J') {
        currentCol -= 1
    } else if (currentRow < map.lastIndex && map[currentRow + 1][currentCol] == '7') {
        currentRow += 1
    } else if (currentCol > 0 && map[currentRow][currentCol - 1] == '7') {
        currentCol -= 1
    } else if (currentRow < map.lastIndex && map[currentRow + 1][currentCol] == 'F') {
        currentRow += 1
    } else if (currentCol < map.first().lastIndex && map[currentRow][currentCol + 1] == 'F') {
        currentCol += 1
    } else {
        throw IllegalStateException("Unhandled case")
    }

    var steps = 1
    visited += currentRow to currentCol

    do {
        if (map[currentRow][currentCol] == '|') {
            if (currentRow > 0 && Pair(currentRow - 1,  currentCol) !in visited) {
                currentRow -= 1
            } else {
                currentRow += 1
            }
        } else if (map[currentRow][currentCol] == '-') {
            if (currentCol > 0 && Pair(currentRow, currentCol - 1) !in visited) {
                currentCol -= 1
            } else {
                currentCol += 1
            }
        } else if (map[currentRow][currentCol] == 'L') {
            if (currentRow > 0 && Pair(currentRow - 1, currentCol) !in visited) {
                currentRow -= 1
            } else {
                currentCol += 1
            }
        } else if (map[currentRow][currentCol] == 'J') {
            if (currentRow > 0 && Pair(currentRow - 1, currentCol) !in visited) {
                currentRow -= 1
            } else {
                currentCol -= 1
            }
        } else if (map[currentRow][currentCol] == '7') {
            if (currentRow < map.lastIndex && Pair(currentRow + 1, currentCol) !in visited) {
                currentRow += 1
            } else {
                currentCol -= 1
            }
        } else if (map[currentRow][currentCol] == 'F') {
            if (currentRow < map.lastIndex && Pair(currentRow + 1, currentCol) !in visited) {
                currentRow += 1
            } else {
                currentCol += 1
            }
        }

        steps++
        visited += currentRow to currentCol
    } while (currentRow != startRow || currentCol != startCol)

    println(steps / 2)

}

private val input = """
    ..F7.
    .FJ|.
    SJ.L7
    |F--J
    LJ...
""".trimIndent()
