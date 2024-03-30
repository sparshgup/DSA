fun main() {
    val lz = LempelZivWelch()

    println()

    // Test Case 1
    val original1 = "AABABBBABAABABBBABBABB"
    val encoded1 = lz.compress(original1)
    val compression1 = calculateCompressionPercentage(original1.length, encoded1.size)
    println("======================================== Test Case 1 ========================================")
    println("Original: $original1")
    println("Encoded: $encoded1")
    println("Compression %: $compression1%")
    println()

    // Test Case 2
    val original2 = "TOBEORNOTTOBEORTOBEORNOT#"
    val encoded2 = lz.compress(original2)
    val compression2 = calculateCompressionPercentage(original2.length, encoded2.size)
    println("======================================== Test Case 2 ========================================")
    println("Original: $original2")
    println("Encoded: $encoded2")
    println("Compression %: $compression2%")
    println()

    // Test Case 3
    val original3 = "HELLOHELLOHELLO#"
    val encoded3 = lz.compress(original3)
    val compression3 = calculateCompressionPercentage(original2.length, encoded2.size)
    println("======================================== Test Case 3 ========================================")
    println("Original: $original3")
    println("Encoded: $encoded3")
    println("Compression %: $compression3%")
}

/**
 * Calculates the compression percentage based on the original size and the compressed size
 */
fun calculateCompressionPercentage(originalSize: Int, compressedSize: Int): Double {
    val compressionPercentage = (1.0 - compressedSize.toDouble() / originalSize) * 100
    return "%.2f".format(compressionPercentage).toDouble()
}