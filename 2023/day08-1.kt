fun main() {
    val caseInput = input
    val lines = caseInput.lines()

    val instructions = lines.first()

    val map = lines.takeLast(caseInput.lines().size - 2).associate {
        val match = "(...) = \\((...), (...)\\)".toRegex().matchEntire(it)!!

        match.groupValues[1] to Pair(match.groupValues[2], match.groupValues[3])
    }

    var node = "AAA"
    var steps = 0

    while (node != "ZZZ") {
        instructions.forEach {
            node = if (it == 'L') {
                map[node]!!.first
            } else {
                map[node]!!.second
            }
            steps++
        }
    }

    println(steps)
}

private val input = """
    LLR

    AAA = (BBB, BBB)
    BBB = (AAA, ZZZ)
    ZZZ = (ZZZ, ZZZ)
""".trimIndent()
