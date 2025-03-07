
fun main() {
    println("Enter the first integer:")
    val num1 = readLine()?.toIntOrNull() ?: run {
        println("Invalid input. Please enter a valid integer.")
        return
    }

    println("Enter the second integer:")
    val num2 = readLine()?.toIntOrNull() ?: run {
        println("Invalid input. Please enter a valid integer.")
        return
    }

    println("Sum: ${add(num1, num2)}")
    println("Difference: ${subtract(num1, num2)}")
    println("Product: ${multiply(num1, num2)}")
    println("Quotient: ${divide(num1, num2)}")
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun subtract(a: Int, b: Int): Int {
    return a - b
}

fun multiply(a: Int, b: Int): Int {
    return a * b
}

fun divide(a: Int, b: Int): String {
    return if (b != 0) {
        (a / b).toString()
    } else {
        "Division by zero is not allowed."
    }
}
