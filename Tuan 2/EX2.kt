fun main() {
    println("Enter a number to check if it is prime:")
    val number = readLine()?.toIntOrNull() ?: run {
        println("Invalid input. Please enter a valid integer.")
        return
    }

    if (isPrime(number)) {
        println("$number is a prime number.")
    } else {
        println("$number is not a prime number.")
    }
}

fun isPrime(num: Int): Boolean {
    if (num <= 1) return false
    if (num <= 3) return true // 2 and 3 are prime numbers

    if (num % 2 == 0 || num % 3 == 0) return false

    var i = 5
    while (i * i <= num) {
        if (num % i == 0 || num % (i + 2) == 0) return false
        i += 6
    }

    return true
}
