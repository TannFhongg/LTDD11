fun main() {
    val array = intArrayOf(10, 20, 30, 40, 50)

    println("Original Array: ${array.joinToString(", ")}")
    println("Sum of elements: ${calculateSum(array)}")
    println("Average of elements: ${calculateAverage(array)}")
    println("Maximum element: ${findMaximum(array)}")
    println("Minimum element: ${findMinimum(array)}")
}

fun calculateSum(array: IntArray): Int {
    return array.sum()
}

fun calculateAverage(array: IntArray): Double {
    return array.average()
}

fun findMaximum(array: IntArray): Int {
    return array.maxOrNull() ?: throw IllegalArgumentException("Array is empty.")
}

fun findMinimum(array: IntArray): Int {
    return array.minOrNull() ?: throw IllegalArgumentException("Array is empty.")
}
