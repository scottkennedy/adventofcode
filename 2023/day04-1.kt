fun main() {
    val points = input.lines().map { line ->
        val gameResults = line.split(":")[1].replace(" +".toRegex(), " ")
        val numberSplit = gameResults.split(" | ")

        val winningNumbers = numberSplit.first().trim().split(" +".toRegex()).map { it.toInt() }.toSet()
        val gameNumbers = numberSplit.last().trim().split(" +".toRegex()).map { it.toInt() }.toSet()

        val intersection = winningNumbers.intersect(gameNumbers)

        if (intersection.isNotEmpty()) {
            1 shl (intersection.size - 1)
        } else {
            0
        }
    }

    val sum = points.sum()

    println(sum)
}

private val input = """
    Card   1: 33 13 28 76 16 91 52 41 38 64 | 52 10  7 61 12 70 84 38 16 40  5 49 33 11 31 43 71 28 72 23 98 47 14 44 90
    Card   2: 96 34 61 84 30 70 67 52 94 43 |  6 11 59 96 25 36 67 84 43 40 55 93 45 12 30 44 15 69 65 78 82 13 54  7 88
    Card   3: 72 40 28 93 22 20  2 79 99 87 | 66 95 26 57 75 45 31 25  5 94 55 34 30 67 70 69 83 59 89 85 92 51 84 80 64
    Card   4: 62 38 16 54 39 36 60 73 91 89 |  2 69  5 49 23 90 78 91 45 14 29 50 58 12 30  3 38 72 27 19 95 80 56 24 16
    Card   5: 94 53 56 21 41 99 42 74 66 84 |  5  3 99 38 67 84 66 45 24 76 90 17 28 42 77 16 23 11 41 91 94 56 74 21 40
    Card   6: 93 94 55 89 11 64  8 86 23 35 | 76 24 36 87 53 88 39 67 43 63 17 16 59 30 94 41 99 51 86 28 47 23 19 11  7
    Card   7: 77 18 37 68 43 13 44 51 12 56 | 48 77 69 11 44 68 78 43 46 72 34 70 35 13 86 14 18 56 52 51 12  9 32 94 54
    Card   8: 90 20 74 33 84 40 78 94 96 31 | 55 31 65 13 64 33 78 34 18 74 29 37 49 14 32 52 84 26 90 25 86 38 96 82 40
    Card   9: 14 51 88 15 91 83 75 37 74 40 | 33 21 97 57 14 12 20 67 91 74 88 83 55 37 36 51 30 13 80 78 71 54 85 98 44
    Card  10: 20 92 44 28 91 39 10 80 33 75 | 18 94 44 46 84 65 41 54 30 91 15 32 49 51 27 31  3 76 19 13 22 23 33 47 74
    Card  11: 73 23 16  6 74 39 47 85  9 88 | 18 81 17 27  8 11 30 63 72 80 10 20 65 64 36  4 46 94 87 70 32 41  2 58 61
    Card  12: 98 92 96 88 49 10 51  4 15  3 | 20 92  4 80 36 39 51 91 97 78 64 13 93 35 81 31  1 89 43 50 74 61 68 46 32
    Card  13: 56  1 75 69 25  9 66 55 20 64 | 46 64 89 27 81 84 36  8 61 55 24 70 41 50 91 47 62 38 82 37 28  7 58 76 99
    Card  14: 11  7 98 56 12 70 37 42 89 51 | 56 64 27 54  8 61 41  3 84 71  9 91 58 23 42 67 49 89 52 81 98 62 14 83 24
    Card  15: 19 66 30 63 59 71 48 97 82 80 | 74 84 77 23 53 56 46 42 87 82 29 86 59 81 21 17 14  1 88 99 13 35 12  4 69
    Card  16: 94 33 97 22 56 60  9 40 28 21 | 50 79 54 31 34 51 43 23  7 76 27 89 62 36 57 55 88 18  6 73 95 19 32 20 52
    Card  17: 60 98 64 76 13 37 74 58 69 89 | 97 25 92 72 86 32 47 27  9 56 23 21 28 24 79 55 51 65 53 77  7 52 17 66 70
    Card  18: 13 59 31  4 33 46 54 73 10 82 | 89 23 56 21 42 60 36 79 77 88 17 97 81 69 22 74 40 96 99 85 87 35 16 43 37
    Card  19:  9  1 48 52 32 35 99 87 33 86 | 52 15 98 23 87 32  5  9 22 86 95 91 99 35 19 72 71 13 33 82 81 48 78 14  1
    Card  20:  6 96 29 97 37 85 57 55 59 39 | 72 50 62 39 90 12 57 41 97 55 32  6 37 15 86  4 68 19 85 65 56 59 96 40 29
    Card  21: 64 33 77 32 88 43 46 23  3 37 | 60 27 99 47 13 63 51 85 40 35 18 16 29 69 86 84 82 21 56  4 34 49 55  2 72
    Card  22: 25  9 84 23 27 73 42 60 54  6 | 60 58 36 40 17 77 69 46 82 51 67 14 50 23 92 45 27 25 55 37 73 84 16 68 54
    Card  23: 74 41 95 46 52 69 31 86 14 21 | 63 75 58 36 46 40 43 68 20 55 31 35 21 74 30 69 45 41 79 64 23 14 78 56 86
    Card  24: 36 90  7 26 85 88 79 24 25  2 | 73 25 77 96 89 79 36 31 53 10 69 92 94 88 24 62 19 99 26 90  2 76 12  7 85
    Card  25: 94 44 48 92  6 84 83 45 90 62 |  4 94 69 92 64 50 67 62 14 17 93 90 44 23  6 43 84 16 83 34 68 72 48 73 45
    Card  26: 60 70 34 33 19 65 86 20 79 81 |  4 32  2 85 65 34  7 39 40 19 86 35 82  6 74 60 18 81 33 49 70 63 76 22 75
    Card  27: 19 60 53 18 90 25 95 54 76 71 | 90 23 55  7 21 66 41 20 44 50 39  6 85 71 56  1 13 77 54 59 40 94 64 98 62
    Card  28: 67 95 69 49 31 74 72 90 85 62 | 23 11  3 63  6 31 19 92 91 42 64 27 62 72 46 59 69 35 13 33 95 99 89 77 67
    Card  29: 50 86 70 98  8 14 39 52 36 99 | 73 70 36  4 62 65 33 25 89 85 55 40 86 84 39 14 98 90 23 17 48 10 52 37 16
    Card  30: 56 20 33 85  1 28 62 83 59 18 | 78 29 77 25 90 93 31 16 54 60  8 67 15 84 35 37 65 53  6 27 45 30 74 86 26
    Card  31: 36 44 32 69 71 58 96 99 33  3 | 44 71 22 64 31 34 59 99 69 48 40 32 33 96 19 47  7 97 50 60 63 58 55 37 36
    Card  32: 22 91 14 28 21  5 68 27 19 63 | 25 64 78 74 21 23 41 28 83  6 38 67 18 54 12 39 79 40 55 69  9 93 35 33 42
    Card  33: 88 61  8 49 27 64 80 16 54 31 | 82 95 31 62 65 24  2 28 76 61 71 10 87 52 38  7 91 53 54 77 37 51 49 41 67
    Card  34: 82  2  1  3 81 63 33 77 95 86 | 82  3 90 20  7 80 14 18 59 11 29  6 28 35 60 27 16 52 77 47 73 24 37 53 26
    Card  35: 32 76 51 90 36 81 11 77  2 16 | 37  6 72 41 27 88 35 38 25 42 82 74 44 29 17 15 23 98 13 56 83 21 20 84 95
    Card  36: 70 89 99 47 59 93 61  2 43  6 | 74 10 46 23 41 51 76 22 54 21 59  2 99 30 73 53  8  4 40 81 86 42 29 82 36
    Card  37: 31 10 87  7 54 92 36 15 20 90 | 20 69  2 37 26 74 54  3 32  4 41 97 81 44 72 49 85 89 98 36 42 80 77 28 78
    Card  38:  7 62 76 88 98 44 90 20 96 42 | 77 70 87 37 34 80 49 48 33 97 69 93 24 78 28 30 43 13  9 98 12 11  6 26  3
    Card  39: 79 66 24 89 21 81 87 60 30 50 | 62 95 34 97 86 53 85 31 57 36 49 88 76 84  5 69 55 64 20 43 33 83 39 12 80
    Card  40: 12 78 89 88 25 57 11 53 59 63 | 42  4 73 80 91 74 32 18  1 71 76 79 90 72 16 14  6 48 58 47 15 17 27 54 56
    Card  41: 91 49 45 37 21 35 15 11 90 16 | 29 11 21 70 35 51 77 45 85 16 27 34 24 60 50 66 20 91 71 49 90 98 15 37 61
    Card  42: 15 29 77 52 20  9  5 95  7  3 |  3 76 45 32 30 36 91 52 46 77 26 65 15 19 95 60 20  5 61  2 29 70  9 40  7
    Card  43: 16 43 22 68 38 67 11 88 57 78 | 73  7  9 34 59 50  8 19 91 53 71 18  5 42 39 82 95 55 37 90  3 77 60 45 65
    Card  44: 67 14 56 23 29 72 48  7 70 27 |  8 74  3 30 78 83 27 69 67 23 49 89 98 64 70 62 66 59 20 68 41 95 45 28 51
    Card  45:  7 85 81 89 72 20 87 99 98 67 | 71 10 67  7  4 85 45 49 16 87 31 72 52 98 99 89 20 83 22 30  1 94 14 35 81
    Card  46:  7 81 22 85 36 82 91 39 54 18 | 54 91 86 14  8 15 38 85 78 73 22 33 60 82 63 53 79  7 48 39 18 81 36 70 61
    Card  47: 87 72 78 34 89 30 73 88 98 20 | 15 55 60 53 36 34 78 21 12 89 79 73 87 91 42  1 52 88  7 86 20 30 98 85 72
    Card  48: 55 71 88 40 92  8 84 33 77 59 | 69  7 13 75 96 98 91 77 36 16 86 10 60 88 61 44 25  9 56 82 94 39 28 63 73
    Card  49: 19 77 18 95 53 30 36 40 52 44 | 87 74 12 61 56 86 44 40 18 93 38  6 72 78 19 77  2 97 53 48 30 52 95 36 47
    Card  50: 25 19 43 59 11 28 77 35 42 54 | 54 72 85 11 52 89 44 26 43 25 45 77  8 42 55 83 70 53 66 79 28 98 71 59 19
    Card  51: 88 28 31 70  1  3 52 48 54 58 | 54 26 18 46 80 62 91 70 42 81 44 48 28  2 79 88  8 58 45 31 93 10 52  3  1
    Card  52: 77  2 81 93 60 67 74 47 42 33 | 58 81 72 38 71 17 61 98 11 89 25 86  3 30 59 90 54 10 41 16 19  4 21 14 84
    Card  53: 54 94 41 42 38 97 72 46 98  5 | 38  6 98 34  5 54 78 41 97 84 72 74 12 94 33 53 63 47 46 10 29 42 70 32  8
    Card  54: 75 14 23  2 55 89  1 82 38 30 | 36 33  6 53 91 49 61 59 87 77 74 66 28 44 50 12 45 51 69 43 32 60 48 96 72
    Card  55: 30  7 65  3 35 17 29 38 15 10 | 97 49 50 23 22 18 41 34 62 44 32 40 95  3 30 19 35 70 75 16 52 89 73 59 10
    Card  56: 55 75 40 65 99 54 17 52 43 10 | 11 18 81 35 15 51 90 58 76 75 96 60 43 99 65 17  5 20 64  3 86 40 54 14 13
    Card  57: 73 14 67 43 42  8 81 78 49 85 | 77 58 89 61 40 91 29 46 12 82 54  3 90 79 50 59 26 66 52 60 17  7 84 14 64
    Card  58: 49 19 12 46 98  1 93 63  5 42 | 39 31 23 54  9 34 88 63 35 13 44 94 69 70 62 36 84 92 59 22  2 48 67 74 19
    Card  59: 18 24 88 94 70 52 37 95  7 10 | 22 74  7 10 32 56 62 93  1 50 48 53 42 94 84 65 75 83 70 90 15 51 34 45 71
    Card  60: 14 30 90 41 60 65 62  6 54  8 | 62 20 22 96 13 36 47 68 77 34 80  3 37 98 42  9 60 84 91 31 44 51 32 21 23
    Card  61: 28 89 60  3 82 29 57 81 76 96 | 67 35 12 99 37 92 84 89 11 24 50 72 49 87 39 42 59 98  4 51  7 79 77 33  9
    Card  62: 11 98 14 64 18  3 82 15 90  7 | 81 13 94  9 38 35 50  6 19 34 54 92 51 86 65 56 39 42 40  7 62  2 73 90 59
    Card  63: 72 40 30 14 13 24 27 29 80 82 | 94 51 31 60 78 17 39 44 29  9 62 73 58 99 57 84 45 52  8 50 76 38 11 67 43
    Card  64: 32 48 87 80 37 14 33  9 86  3 | 92 79 71 57 70 25 34 45 42 89 72 44 68 58 43 27 50  4 93 28 82 90 16 13  2
    Card  65: 38 72 21 28 84 78 11 48 30 75 | 58 75 68 18 11 81 84 48 14 21 64 85 30 78 72 20 38 28 25  1 74 95 88 60 47
    Card  66: 84  2 78 28 32 30 98 29 94 11 | 55 96 13 24 30 41  2 98  9 34 60 66 75 28 73 51 72 47 92 77 53  4 25 58 84
    Card  67: 77 30 96 14 62 81 91 65  6 12 | 67 95 54 30 18 94 81 92 14 91 86  1 65  6 12 77 48 37 55 87 70 24 32 96 62
    Card  68: 73 27 60 15 56 98 94 17 67 88 | 98 87 94 71 85 21 15 88 73 70 56 34 10 30 17  8 22 61 78 25 27 95 67 60 29
    Card  69: 47 58 70 23 38 89 82 19 90 54 | 38 45 23 53 97 35 89 90 70 58 54  1  6 19 82  3 78 28 18 86 93 47 62 61  5
    Card  70: 58 33  3 23 84 59 14 55 79 82 | 59 84 33 40 61 44 55 18 74 86 22 49 81 82 37 97 41 77 79 63 42 36  3 34 91
    Card  71: 17 65 87 56 52 91 38 15 67 84 | 70 15 91 11 88 54 56 84 87 71 17 47 85 60 83  6 65 52 80 38 61 19 50 67 75
    Card  72: 18 88 83 23 79 63 11 99 56 15 | 94  2 52 83 17 58 79 29  4 42 61 11 74 56  9 63 88 49 46 68 37 85 21 90 73
    Card  73: 66 42 17 10 75 54 51 49 47 13 |  2 21 89 10 49 60 92 69 19 51 74  1 96  3 29 43  5 87 35 54 53 63 24 33 50
    Card  74: 56  3 37 77 31 91 62 26 51 84 | 36 33 96 38 21 11 91 47 75 98 66 87 62 83 95 64 16 29 14 69 45 57 89 92 56
    Card  75: 93 19 88 42 44  2 79 99 31 87 | 20 91 53 42 49 88 22 44 50 38 35  2 55 99 87 27  3 59 19 97 31 79 93  1  9
    Card  76: 71 50 29 85  8 42 19 27 64 20 | 68 22 46 49 94 76 29  8 75  9 16 89 57 23 90 85 39 64 83 34 55 51 35 19 62
    Card  77:  5 57 91 52 90 44 36 84 65 83 | 36 44 31 57 92 42 19 17 73 95  5 86 13 93 25  4 83 88  2  3 46 33 20 22 74
    Card  78:  8 83 72 20 95 78 58 63  4 79 |  2 44 61 62 36 93 82 16 54 80 75 88 25 76 24 41 55 43 89 40 45 52  5 81 15
    Card  79: 44 76 31 26 16 84 57 80 12 28 | 65 33 94 23 29 87  4 61 40 85 55  3 62 15 54  1 66 81 76 59 84 79 28 37 34
    Card  80:  8 45 69 98 12 24 79 72 67  5 | 37 33  5 71 67 45 72 79 97 87 69 11 85 55 64 75 98 86 54 88 80 12 36 22 94
    Card  81: 11 85 49 35 72 64 31 55 25 62 |  2 94 36 11 88 55 98 25 39 12 62 95 90 81 74 15  3 35 29 28 34 89 21  4 40
    Card  82: 79 76 87  8 27 97  5 14 31 78 | 34 22 29 99 60 62 76 96  2 72 82 20 36 50 33 45  5 81 80 23 70 27 14 18 97
    Card  83: 39  3 23 88 62 67 32 26  7 10 | 51 76 13 74 99 25 95 54 78 63 59 60 18 16 21 88 62 37 55  9 90 26 33  5 67
    Card  84: 72  7 78 98 87 28 27 15 35 57 | 57 69  9  2 82  3  5 72 46 71 14 24 52 90 68 32 56 44  8 51 38 98 58 78 86
    Card  85: 64 62 82 85 42 81 95 33 76 39 | 32 59  7 39 60  5  8 66 64 93 65 23 70 48 26 88 18 77  6 56 92 11 87 43 20
    Card  86: 12 37 92 84 97 87 48 11 26 94 | 54 80 75 94 91 99 71 23 95 98 36 25 96 76 82 83  6 65 73 77 22 61 31 84 49
    Card  87: 54 52  1 61  3 19 84 58 27 68 | 79 15 41 37 93  5 67 34  8 30 45 75 96 47 70 95 10 60 21 26 20  4 32 94 46
    Card  88: 47 49 95 31 36 53 37 86 92 42 | 58 22  6 14 62 50 93 23 43 11 90 67 60 56 40 81 75 91  2 45 65 25 69  1  5
    Card  89: 56 58 18 63 62 26 57 17 15 68 | 24 78 68 74 15 57 82 14 18 41 56 32 90 94 71 58 83 43 60 62 30 59 26 63 17
    Card  90: 20 52 11 58 88 65 78 41 27  6 | 20 50 70  1 76  3 88 51 78 41 95 58 32 63 65 69 52 72 97 67 27 11 62  6 48
    Card  91: 48 11 70 69 55 37 78 29 51 63 | 77 34 16 28 47 48 62 37  3 40  6 55 70 90 43 74 11 78  4 29 51 69 80 66 63
    Card  92: 36 85 20 15 24 84  3  6 96 35 | 89  1 70 93 88 82 48 64 32 62 53 72 51 97 52 77 65 76 86 90 75 40 54 95 10
    Card  93: 38 29 33 46 22 64 40 20 59 75 | 38 44 39 76 88 60 29 75 96 46  9 32 79 95 59 33 58 62 53 18 21 40 74 20 64
    Card  94: 20 11 96 56 65 94 18 36  6 25 | 87 45 99 94 49  8 12 85 11 18 56 47 51 27 36 20 21  6 17 86 25 52 65 90 96
    Card  95: 62 16 86 28 55 38 46 61 51 29 | 53 16 46 29 61 80 62 38 57 55 44 45 99  3 35 28 87 51 82 27 41 86 89 71  4
    Card  96:  5 27 96 44 38 22 58 42 55 59 | 81 41 58 45 22 24 74 30 62 11 99 98 31 65 82 14 17 28 79 76 73 25 78 91 75
    Card  97: 81 45 87 42 52 15 19 67 74 35 | 16 34 55 18 89 87 42 45 79  4 30  5 65 15 74 28 39 75 19 52 81 57 67 98 38
    Card  98: 51 64 39  8 68 33 54 45 66  2 | 72 93 95 97 30 71 64 22  7 38 41  3 35  1 42 46 20  9 12  5 24 82 17 14 10
    Card  99: 48 64 78 81 69 27 24 33 13 62 | 81 33 46 86 77 84 43 50 85 13 35 24 14 53 58 64 79 15 21 78 44 83 75 73 59
    Card 100: 64 99 51 17 28 31 69 15 40 82 | 45 96 28 17 18 78 85 89 20 98 33 99 88 31 74 81  1 62 76 66 54 41 15 87 83
    Card 101: 22 53 69 94 79  4 60 10 70 17 | 58 86 42  3 63 66 49 52 65 51  6 54 60  2 96 73 18 31 41 76 39 93 84 56 25
    Card 102: 31 30 76  9 28 53 27 74 29 42 | 21 79 32 17 14 33 19 34 52 81 40 95 45 60 68 18 80 57 44 51 72 83 67 77 46
    Card 103: 85 86 75 41 25 21 96 65 27 93 | 87 64 88 76 59 53 45 39 12 83 99 37 55 50 85  5 54 66 13 46 61 92 79 82 77
    Card 104: 27 80 71 95 91 92 14 86 11 84 | 94 27 46 58  3 68 29 63 12 79 50 48 36 34 49  1 55 28 76 30 73 86 74 41 64
    Card 105: 88 68 74 93 81 29 83 92 43 61 | 25 63 19 78  2 13 94 95 37 86 10 70 52 22 12 32 24 17 77 28 90 60 41 46 76
    Card 106: 17 25 37 28 11  6 22 81 73 54 | 88 90 92  9 68 38 86 36 59 30 12 78 99 77 91 44 98 15 75  4 89 34 67 85 69
    Card 107: 66 42 27 47 55 70 84  2 60 94 | 86 36 90 74 71 49 79 73 21 31 75 91 39 37 14 88  4 30 67 62 53 78 34  5 18
    Card 108: 38 19 97 44 71 81  8  2 32 59 | 59 38 65 81 34 32 45 19  2 44 97 91 71 41 31 42  3 43 26 30 94 75  8 93 46
    Card 109: 60 57 12 56 34 68 23 77 16 95 | 34 83 57 66 46 50 33 67 77 44 12 68 91  5 89 25  1 27 38 96 61 23 16 56 51
    Card 110: 25 35 10 85 43 64 36 54 59 75 | 64 59 25 52 41  8 91 31 24 37 61 23 56 19 65 46 87  7 85 98 14 36 77 70  4
    Card 111: 52 56 21 47 83 43 81 32 85 89 | 65 47  2 15 63 68 31 94 46 55 77 16 75 21 81 60  7 13 61 84 73 43 35 85 53
    Card 112: 30 45 67  3  5 16 32 37 61 19 | 96 16 42 54 58 71 17 59  5 19 48 53  3 76 15 67 81 37 45 61 77 30 32  4 89
    Card 113: 13  1 30 36 77 44 98 34 60 39 | 14  4 62 70 22 78 63 16 15 93 33 97 61  8 13 79 67 85 44 26 76 10 24 86 83
    Card 114:  4 94 86  9 41 51 54 19 47 98 | 21 73 62 25  3 51 59  6 89 84 99 66 90 39 42 44 46 31 92 86 47 33 50 70 94
    Card 115: 32 88  4 45  8 13 30 53 39 84 | 68 55  4 13  8 39 30  3 69 86 38 88 32 84 35 21 42 12 25 57 40 53 20 73 45
    Card 116: 63 69  5 87 52 17 47 90 13 80 | 66 14 49 46 91 29 13 87 94 71 52 47  1 18 63 62  8 90 69  5 17 36 57 16 83
    Card 117: 72 51 38 77 61 29 79 86 82 13 |  8 13 45 24  5 65 29 77 26 88  9 72 95 86 68  7 50 18 61 15 92 89 21 42 12
    Card 118: 58 99 35  2 79  5 69 92 81 87 | 99 97 44 42  9 48 32 17 35 61 39 73 46 10 29 78  6 11 26  1 58 69 70 62 60
    Card 119:  7 54 11 25  5 23 49 15 60 86 | 50 93 18 74 42 97 82 37 25  4 64 45 55 60 12  5 32 15 61  2 92 24 52 11  7
    Card 120: 76 90 43 41 33 88 59 51 17 85 | 56 10 82 20 15 85  4  9 66 80 35 19 28 76 26 47 94 48 43 88 90 49 54 13 65
    Card 121: 67 15 35 92 23 20 42 96  3 33 | 46 89 65 40 82 75 67 55 86 18  1 85  6 98 35 52 94 70 72 45 53 15 39 32 96
    Card 122: 67 19  5 40 46 69 91 38  7 37 | 89 58 17 41  4 93 82 26 96 55 21 56 33 54 30 86 27 37 70 11 66 62 79 98 29
    Card 123: 76 83 25 88 80 84 18 17 59 95 | 12 97 45 83 79  4 96 28 54  1 63 95 42 84 20 18 61 66 39 65 76 11 19 59 48
    Card 124: 30 32 35 22 99 83 96 75 44 18 | 62 93 12 28  8 22 46 53 73 81 86 33 52 83 99 20 75 77 25 95 96 30 34  5 45
    Card 125: 33  4 28 95 59 90 75 56 41 81 | 55 86  3 50 34 47 53 30 58 32 31  7 56  8 97 77  4 59 39 71 80 52 51 92 75
    Card 126: 56 45 12 87 60 81 62  9 57 14 | 26 99 38 93  6 27 14 18 30 62  5 48 57 81 92 44  2 82 60  8 17  4 90 84 96
    Card 127:  1 26 58 85 83 14 17 97 39 52 | 99 84 11 18 53 57 54 31 10 15 27 78 34 40 87 70 66 23 88 51 85 41 91 49 94
    Card 128: 74 35 93 76 37 63 34  5 27 90 | 59 25 27 94 88 51 26 85 99 71 79  6 19 66 35  7 53 70 39 97 11 45 33 63  3
    Card 129: 32 10 99 75 63 20 60 39 47 57 | 57 37 97 96 77 32 80  1 38 68 29  7 64 33 11 13 40 28 94 91 72 42  4 79 18
    Card 130: 34 95 55 38 43 78 61 40 60 57 | 42 16  2  1 17 35  3 44 13 58 81 39 54 94 50 89 99 79 80 14 46 74 73 36 66
    Card 131:  5 49 48 82 20 43 61 19 71 50 | 62 25 65 36 93 45 41 39 69 84 60 38 42 16 58 87 53 15 63 79 72 52 98 51 11
    Card 132: 38 56 27 25 40  2 34 57 33  6 |  2 33 61 40 38 62 57 34  6  5 15 51  8 26 36 82 27 37 94 73 92 13 56 25 53
    Card 133: 19 93 69 50  6 42 40  4 72 95 |  9  4 72 80  7 95 11 29 69 50 78 24  6 93 42 79 34 46 23 19 63 40 68 58 26
    Card 134: 56 42 87 73 15 59 40 45 97 19 | 87 88 78 56 21 59 15 42 72 43 45 68 13 19 12 61 40 76  9  8 91 99 55 73  6
    Card 135: 54 53 62 63 55 46 38 83 61 70 | 68 51 71 19 92 81 21 35 93 41 27 22 89 25 23 95 18 69 11 60 73 34 65 12 66
    Card 136: 57 77 51 20 39 60 12 79 80 34 | 20 71 77  2 40 78 46 18 28 85 49 63 36 39  7 84 76 56 51 15 97 11 42 74 35
    Card 137:  3 31 86 18 59 61 60 74 95 93 | 66 45 70 29 81 99  3 98 83 68 97  2 34 24 14  8 20 28 75 47  5  1 38 94 27
    Card 138: 59 40 75 77 70 44 54 62 36 11 | 81 55 58 16  1 41 91 72 83 31 63 92 24 82 84 56 76 15 12 35 34 79  6 44  2
    Card 139: 88 42 81 10 55 97 30 59 86 38 | 57 81 24 12 33 20 13 66 67 42 54 41 46 31 18 10 19 59 87 91 74 39 50 86 71
    Card 140: 53 86 32 85 31 87 50 55 81 10 | 90 77 58 66  8 35 49 13 80 70 82 50 95 20 53 63 10 19 81 55 62 67 93 84 32
    Card 141: 79 67 77 68 41 62  7 87 58 51 | 70  6 91 32 71 48 97 40 37 95 55 58 34 14 61 63 51 30 62 45 42 28 50 38 17
    Card 142: 62 37 36  3 13 41  7  4 58 78 | 41 13 22 51  2 18 95 10 63 32 67 82  4 97 44 96 64 21 74 46 14 78 88 47 89
    Card 143:  8 31 78 87 95 23 56 83 63 61 | 11 68 28 94 79 55 57 39 71 74 93 92 88 35 10 15 29 75  6 90 43 97  9 45 54
    Card 144: 96 76 14 44 34 37 94 51 54 61 | 12 50 19 56 27 84 90 47 71 21 10 13 54 65 55 81  4 57 92  7 18 70 25 36 79
    Card 145: 85 86 18 19 59 87 11 42 93 58 | 70 14 25 90 12 31 74 73  1 64 80 68  2 38 61 34 37 78 76 17 20 33 84 30 62
    Card 146: 98 55 33 71 72 70 23 18  1 31 | 38 34 41 93 50  6 91 35 24 68 63 86 54  5 28 94 51 27 46 56  4 79 90 61 12
    Card 147: 47 85 31 82 83 11 74  2 28 14 | 82 11 34 31 71 83 20 72 74 38 18 57  7 47 28 54  2 85 14 35  6 36 64 49 90
    Card 148: 22 99 68 89 87 53  2 59 73 70 | 84 46  2 82 10 83 59 42  7 22  9 97 45 99 64 39 89 68 73 28 87 30 13 70 53
    Card 149: 64 69 93 20 17 41 26 66 42 50 | 68 82 51 40 19 41 37 74 20  6 50 75  7 28 35 30 10 66 64 63 26 17 11 78  1
    Card 150: 13 16 41 80 89 56 96 84 70  8 | 96 93 40 81 25 56 58 42  1 19 75 92 97 44  7 90 41 50 82 64 60 33 84 85 52
    Card 151: 77 48 40 89 73 21 52  3 16 83 | 83 75 69 26 73 96 86  9 71 97 23 22 80 52 92 70 58 16 82 46 94 14 77 13  3
    Card 152: 37 92 66 63 36 30 22 38 20 78 |  6 88 39 31 77 12 76 51 36 44 28 49 16 96 17 81 72 10 74 56  2 33 80 82 91
    Card 153: 87 62 58 54 35 64  3 79 31 99 | 79 88  7 56  9 29 47 14 64  6 83 25 76 42 84 35 69 54 99 60 36 62 66 74 58
    Card 154: 66 54 61  2 44 49 13 31 94 95 | 23  9 50 67 34 18  8 77 20 51 10 76 21 85 37 46 49 63 80 22 74 31 91 29 35
    Card 155: 22 73 88 26  1 59 20 51 65 14 | 98 42 73 52  4 22 46  7 25 59 68 92 19 51 65  3 75 76 86 96 84 16 71 70 89
    Card 156: 21 74 31 88  1 34 79 55  8 71 | 16 98  1 79 74 31 40 77 21 33  7  8 55 70 24 71 29 44 91 65 34 75 11 64 88
    Card 157: 86 79 97 58 57  7  8  3  2 84 |  8 11 15 33 36 63 92 32 75 39 65 88  2 67 10 35 69 26 50  3 31 86 28 70 90
    Card 158: 56 55 29 60 44 47  2  6 38 61 | 31 57 91 55 61  3 94 18 50 29 52 89  6 13 51 83  2 38 81 72 58  9  1 56 68
    Card 159: 39 22 19 15 97 66 78 50  9 58 | 57 36 51  9 85 56 19 82 14 98 92 27 17 75 90 55 91 83 43 18 66 96 35 30 64
    Card 160: 30 58 97 94 60 72 19 91 76 75 |  2 44 50 94 79 10 27 72 33 97 48  9 12  5 17 84 57 30 19 46 52 18 54 78 58
    Card 161: 43 85 76 74 94 27 67 97 45 33 | 94 67 15 85 75 61 29 95 42 23 79 16 40 43 50 18 60 97 74 73  9  4 27 63 76
    Card 162:  8 13 29 90 65 31 36 88 56 83 |  5 66  4 73 22  3 81 97 55 89 83 74 78 67 17 44 30 12 10 93 23 85 88 47 94
    Card 163: 92  8 77 37 71 28 67 88 10 36 | 88  8 98 15 42 56 47 71 48 92 67 90 73 79 30  3 75 23 41 39 55 50 65 52 49
    Card 164: 91 72 54  3 41 97 32 14 43 79 | 87 92 74 20  4 69 41 76 34 29 21 35 52 47 73 50 55 46 26 77 39 48 94 98 68
    Card 165:  1 19 84 86 88 60  4 79 45 82 | 96 94 39 97 91 84 85 52 11  6 89 70 57 16 28 83 75 54 30 81 37 68 47 32 31
    Card 166: 91 32 52 95 46 27 45 93 66 22 | 58 97 19 71 25 74 78 87 47 17 60  6 54 23 82 40 62 93 73 86 12 61 24 37 94
    Card 167: 80 21 76 30 78 41 40 12 86 95 |  2 39 61 40 51 99 15 49 16 24 38 81 10  1 86 98 26 54  3 28  4 13 60 18 89
    Card 168: 58  8  6 45 47 91 97 21 78 70 | 77 80 29 93 54  5 94 51 26 15 75 79 50 58 37 20 34 41  4  9  2 92 43 11 68
    Card 169: 37 21 95 82 47 41 15 29 69 77 | 52  6 19 20 93 22 67 51 83  3 66 54 46 36 43 73 78 87 56 32  7  9  5 57 58
    Card 170: 79 70 26 45 80  6 68 60 11 13 | 96 10 82 62 52 68 44 70 23 85 20  6 93 71 54 45 83 13 77 79 60 65 15 80 29
    Card 171: 72 95 15 93 40 54 89  5 57  8 | 93 19 26 96 86 16 54 30 58  8 89 74 64 98 95  5 57 56 60  1 72 15 63 40 87
    Card 172: 16 86 32 43 80  3 13 70 15 79 |  3 10 25 41 98 76 77 15 32 12 35 42 43  1 72 70 16 86 13 80 87 51 50 47 79
    Card 173: 64 26 99 92 87 48 52 27 71 49 | 98 22 51 69 61 62 90 10 83 42 21 28 59 41 56  8 91 72 13 99 73 44 77 96 32
    Card 174: 24 70 12 60 64 40  9 97 22 94 | 94 62 58 60 37 24 49 55 40 96 85 64 28 70 32 61 33  9 29 22  5 88 69  1 87
    Card 175: 45 92  4 90 84 12 53 60 94 78 | 16 48 92  6 65 21  4 64 60 84 15 13 94 53  1 17 50 54 69 78 91 12 45 33 52
    Card 176: 21 47 68 95 40 78 12 59 11 99 |  6 45  9 57 65 40 72 54 67 78 86 11 77 21 99 59 68 70 10 46 12 47 63 95 25
    Card 177: 58 41 76 13 61 60 51 39 29 11 | 86 57 63 29 31 61 51 76 14 39 13 69 68 87  2 11 60  3 44 48 41 23 58 10 19
    Card 178: 37 77 22 55 83 88 23 57 42 61 | 66  6 23 29 40 74 28 82 52 79  1 70 42 60 49 89 84 65 91 56 58 18 27 30 38
    Card 179: 15 68 56 94 37 53 42 50 89 73 | 76 21 94 69 50 13 71 29 68 74  8 72 53 60 37 75 61 20 57 97 42 89 66 15 38
    Card 180: 75 43 94 39 96 26 77 24 54 44 |  9 86 73 64 97 76 39 61 72 83 98 35 11 46 41  6 56 12 58 79 69  1 63 17 62
    Card 181: 51 69 95  1 94 33 14 41 13 10 | 67 30 72 37 51 23 41 35  7 94 10 22 19 47 40 95  1 14 69 15 33  2 66 73  9
    Card 182:  9 18 12 10 25 88 20 79 82 70 | 45 92 55 26 62 20  4 44 25 65 74 33 98 80 39 82 73 88  8 76 96 64 91  1 13
    Card 183: 16 81 65 60 74 23 30 58 41 24 | 51 26 45 69  7 14 54 55 37 59 36 61 67 76 35 19 11 22 66 34 88 25 28 49 20
    Card 184: 82 21 58 27 24 49 57 96 18  5 | 26 72 75 94 70 12 79 34 48  1 43 46 84 61 28 82 23 35 55 27 74 39 51  4  6
    Card 185: 45  4 87 96 22  8 89 92 90 46 | 88 86 91 56  8 99 20 84 67 36 44 30 83 62 40 11  3 52 10  4 98 22 34 80 12
    Card 186: 23 52 32  9 61 36 72 66 71 63 | 87 25 23 58 71 26  8  6 73 85 95 84 81 56 67 18 76 97 92 66 47 63 40 33 28
    Card 187: 53  5 27 81 98 99 19 33 29 84 | 26 94 22 93 19 86 95 12 56 14 43 30 42 37 49 85 97 13 92 25 80  7 66 38 10
    Card 188: 95 42 64  8 41 49 76 12 83 51 | 58  9 18 71 49 84 29 23 82  1 19 35 14  2 44 31 59 16 33 76 11 34 15 77 55
    Card 189: 54 72 26 70 36 51  6 52 56 97 | 47 19 71 87 16 23 61 30 46 39 34 20 50 84  1 38 49 12 10 27 54 93  3 65 58
    Card 190: 78 74 14 38  2 76  7 39 69 23 | 53 10 46 30 21 27 35 57 85 20 50  5 79 75 56 34 91 51 61 92 37 55  3  6  8
    Card 191: 47 89  3 48 83 13 37 94 61 73 | 72 40 11 49 58 69 35  7 20 71 60 27  6 56 45 85 98 86  9 19 10 67 50 21  2
    Card 192: 34 23 11 97 22 91 74  7 12 32 | 42 21 37 68 73 48 22 94 79 23 60  7 28 32 33 62 92 97 17 65  6 45 12 87 16
    Card 193: 24  5 11 13 20 97 72 88 75  7 | 29 12 13 70 78 15  9 26 10  2 88 67  4 27 80 61 22 93  8 77 94 11 97 53 57
    Card 194: 23 81 13 94 91 98 34  7  4 72 | 89  3 28 97 81 83 36 22 98 85 99  4 87 33 78 84 96 91 40 12 60  7 34 16 68
    Card 195: 70 33 31 71  7 48 64 98 12 30 | 94 96 27 29  1 16 66 98 24 40 20 60 78 13 99 57 64 79 12 18 59 42 54 31  6
    Card 196: 26 12 68 34 70 59 47 60 46 42 | 70  4 32 72 28 97 38 15  7 84 92 73 50 77 36 71 57 10 48  3 39 90 22 25 31
    Card 197: 48 37 61 66 59 97 56 18 31 54 |  3 89 59 56 12 31 99 41 88 83 61 28 13 18 97 48 70  9 37 54 72 42 53 69 66
    Card 198: 72 25 97 60 50 16 27 94  8 31 | 54 20 16 52 82 97  3 49 27 58 63 50 67 18 36 25 12 78  5 87 26 74 38  8 60
    Card 199: 42 90 25 60  5 89 23 15 69  9 | 45 82 46 49 85 13 57 98 16 27 67 41 94 89 25 90 54 33 93 43 12 58 37  4 47
    Card 200: 49 66 80 56 79 46 13 96 33 35 | 96 69  4 48 99 43 92 20 27 13 73 66 45 84 28 17 90 68 56 51 65 57 80  1 32
    Card 201: 47 11 38 30 68 69 39 63 70 18 | 73 65  8 46  5 74 62 93 76 91  2 21 98 80 84 23 24 86 79 55 32 27 99 50  4
    Card 202: 89 35 58  7 45 36 70  9  4 24 |  5 31 29  8 26  7 67 94 20 96 68 50 79 91 86 87 38 59 52 75 98 64 33 83 27
    Card 203: 86 41 53 76 15 39 95 97 42 90 | 11 46 40 82 33 12 44  9  8 52 83 60 99 72 27 71 26 70 36 61 43 90 18 94  7
    Card 204: 98  8 47 91 60 54 93 58 97  2 | 18 71 76 35 44 16 41 33 17 29 61 57 63 43 12 88 87  7 19 83 66 15 28 78 60
    Card 205: 81 93 68 60 88 66 31 19 86 63 | 47 88 84 64 27 59  4 29 35 37 53  2 10 83 51 11 36 66 52 41 57 24 62  3 71
    Card 206: 82 47 81 80 67 69 61 10 25 64 |  8 33 70 16  5 87 41 60 66 36 69 82 14 61 55 47 56 25 91  6 17 52 84 63 53
    Card 207: 51 22 90  8 72 78 61 97 25 24 | 93 59 91 87  2 28 35 16 76 34 49 63 48 98 83 37 85 13 67  4 18 30 43 60 51
    Card 208: 79 15  9 29 75 21 18 54 12 32 | 38 26 17 58 96 51 18 73 35 16 49  7 33 77 74 83  2 75 71 44 29 11 78 52 13
    Card 209: 81 45 40 33 88 41 95 89 15 51 | 31 41 14 55 76 58 23 73 12 10 69 17 61 71  6 21 82  8 20 57 42 66 95 37 72
    Card 210: 59 34 33 58 87 69 61 50 57 51 | 92 75 30 68 71 53 27 36 83  6 46 91 86 31 81 85 32 22 29 17 70 10 43 65 82
    Card 211: 64 96 60 28 57 95 52 85 61 24 | 72 81 21 30 10 77 97 69 68 34 83 33 42  6 87 27  9  8 12 59 37 18 53 14 43
""".trimIndent()
