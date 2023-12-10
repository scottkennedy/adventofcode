fun main() {
    val caseInput = input

    val handsAndBids = caseInput.lines().map {
        val split = it.split(" ")
        val hand = split[0]
        val bid = split[1].toInt()

        Hand(hand) to bid
    }

    val sorted = handsAndBids.sortedBy { it.first }

    val winnings = sorted.mapIndexed { index, handAndBid ->
        (index + 1) * handAndBid.second
    }.sum()

    println(winnings)
}

private data class Hand(
    val cards: String,
    val rank: Rank = Rank.fromHand(cards),
) : Comparable<Hand> {
    override fun compareTo(other: Hand): Int {
        if (rank.rank < other.rank.rank) {
            return -1
        }
        if (rank.rank > other.rank.rank) {
            return 1
        }

        (0 until 5).forEach { index ->
            if (cardToRank[cards[index]]!! < cardToRank[other.cards[index]]!!) {
                return -1
            }
            if (cardToRank[cards[index]]!! > cardToRank[other.cards[index]]!!) {
                return 1
            }
        }

        return 0
    }
}

private val cardToRank = mapOf(
    'A' to 14,
    'K' to 13,
    'Q' to 12,
    'T' to 10,
    '9' to 9,
    '8' to 8,
    '7' to 7,
    '6' to 6,
    '5' to 5,
    '4' to 4,
    '3' to 3,
    '2' to 2,
    'J' to 1,
)

private enum class Rank(val rank: Int) {
    FIVE_OF_A_KIND(6),
    FOUR_OF_A_KIND(5),
    FULL_HOUSE(4),
    THREE_OF_A_KIND(3),
    TWO_PAIR(2),
    ONE_PAIR(1),
    HIGH_CARD(0),
    ;

    companion object {
        fun fromHand(hand: String): Rank {
            val jokers = hand.count { it == 'J' }
            val cards = hand.groupBy { it }.filter { it.key != 'J' }

            return if (cards.size <= 1) {
                FIVE_OF_A_KIND
            } else if ((cards.maxOfOrNull { it.value.size } ?: 0) + jokers == 4) {
                FOUR_OF_A_KIND
            } else if (cards.size == 2) {
                FULL_HOUSE
            } else if ((cards.maxOfOrNull { it.value.size } ?: 0) + jokers == 3) {
                THREE_OF_A_KIND
            } else if (cards.count { it.value.size == 2 } == 2) {
                TWO_PAIR
            } else if (cards.any { it.value.size > 1 } || jokers > 0) {
                ONE_PAIR
            } else {
                HIGH_CARD
            }
        }
    }
}

private val input = """
    32T3K 765
    T55J5 684
    KK677 28
    KTJJT 220
    QQQJA 483
""".trimIndent()
