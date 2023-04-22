fun main() {
    val numberLimit = 10_000L
    val iterationLimit = 50

    val lychrelNumbers = mutableSetOf<Long>()
    (1..numberLimit).forEach{ startingNumber ->
        var workingNumber = startingNumber
        for (iteration in 1..iterationLimit) {
            try {
                workingNumber = reverseAndAdd(workingNumber)
                if (isPalindrome(workingNumber)) {
                    break
                }
            } catch (e: Exception) {
                break
            }
        }
        if (!isPalindrome(workingNumber)) {
            lychrelNumbers.add(startingNumber)
        }
    }

    println(lychrelNumbers)
    println(lychrelNumbers.size)
}

fun isPalindrome (num: Long): Boolean {
    val numString = num.toString()
    return numString == numString.reversed()
}

fun reverseAndAdd (num: Long) = num + reverse(num)
fun reverse (num: Long) = num.toString().reversed().toLong()