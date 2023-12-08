fun main() {
    val caseInput = input

    val times = caseInput.lines().first().split(":")[1].trim()
        .replace(" +".toRegex(), " ").split(" ").map {
            it.toInt()
        }
    val distances = caseInput.lines()[1].split(":")[1].trim()
        .replace(" +".toRegex(), " ").split(" ").map {
            it.toInt()
        }

    val ways = times.zip(distances).map { (time, recordDistance) ->
        (1..<time).map { attemptTime ->
            val distance = (time - attemptTime) * attemptTime

            if (distance > recordDistance) 1 else 0
        }.sum()
    }

    var margin = 1
    ways.forEach {
        margin *= it
    }

    println(margin)
}

private val input = """
    Time:      7  15   30
    Distance:  9  40  200
""".trimIndent()
