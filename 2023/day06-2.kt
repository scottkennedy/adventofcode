fun main() {
    val caseInput = input

    val time = caseInput.lines().first().replace(" ", "").split(":")[1].toLong()
    val recordDistance = caseInput.lines()[1].replace(" ", "").split(":")[1].toLong()

    val ways = (1..<time).map { attemptTime ->
        val distance = (time - attemptTime) * attemptTime

        if (distance > recordDistance) 1 else 0
    }.sum()

    println(ways)
}

private val input = """
    Time:      7  15   30
    Distance:  9  40  200
""".trimIndent()
