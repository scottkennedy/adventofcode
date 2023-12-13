fun main() {
    val caseInput = input
    val lines = caseInput.lines()

    val values = lines.map { line ->
        val sequence = line.split(" ").map { it.toInt() }.toMutableList()

        val sequences = mutableListOf(sequence)

        while (sequences.last().any { it != 0 }) {
            val currentSequence = sequences.last()
            sequences += currentSequence.takeLast(currentSequence.size - 1).mapIndexed { index, value ->
                value - currentSequence[index]
            }.toMutableList()
        }

        (sequences.lastIndex - 1 downTo 0).forEach { index ->
            val currentSequence = sequences[index]
            val newValue = currentSequence.first() - sequences[index + 1].first()

            sequences[index] = buildList(currentSequence.size + 1) {
                add(newValue)
                addAll(currentSequence)
            }.toMutableList()
        }

        sequences.first().first()
    }

    val sum = values.sum()

    println(sum)
}

private val input = """
    0 3 6 9 12 15
    1 3 6 10 15 21
    10 13 16 21 30 45
""".trimIndent()
