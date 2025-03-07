fun main() {
    println("Enter at least 3 scores separated by spaces:")
    val input = readLine()

    val scores = input?.split(" ")?.mapNotNull { it.toIntOrNull() }

    if (scores == null || scores.size < 3) {
        println("Invalid input. Please enter at least 3 valid integer scores.")
        return
    }

    val average = scores.average()
    val grade = assignGrade(average)

    println("Scores: $scores")
    println("Average: %.2f".format(average))
    println("Grade: $grade")
}

fun assignGrade(average: Double): Char {
    return when {
        average >= 90 -> 'A'
        average >= 80 -> 'B'
        average >= 70 -> 'C'
        average >= 60 -> 'D'
        else -> 'F'
    }
}
