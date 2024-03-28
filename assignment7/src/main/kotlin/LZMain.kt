fun main() {
    val lz = LempelZiv()

    println()

    // Test Case 1
    val original1 = "AABABBBABAABABBBABBABB"
    val encoded1 = lz.encode(original1)
    val decoded1 = lz.decode(encoded1)
    val compression1 = calculateCompressionPercentage(original1.length, encoded1.size)
    println("======================================== Test Case 1 ========================================")
    println("Original: $original1")
    println("Encoded: $encoded1")
    println("Decoded: $decoded1")
    println("Compression %: $compression1%")
    println()

    // Test Case 2
    val original2 = "TOBEORNOTTOBEORTOBEORNOT#"
    val encoded2 = lz.encode(original2)
    val decoded2 = lz.decode(encoded2)
    val compression2 = calculateCompressionPercentage(original2.length, encoded2.size)
    println("======================================== Test Case 2 ========================================")
    println("Original: $original2")
    println("Encoded: $encoded2")
    println("Decoded: $decoded2")
    println("Compression %: $compression2%")
    println()

    // Test Case 3
    val original3 = "HELLOHELLOHELLO#"
    val encoded3 = lz.encode(original3)
    val decoded3 = lz.decode(encoded3)
    val compression3 = calculateCompressionPercentage(original2.length, encoded2.size)
    println("======================================== Test Case 3 ========================================")
    println("Original: $original3")
    println("Encoded: $encoded3")
    println("Decoded: $decoded3")
    println("Compression %: $compression3%")
}

/**
 * Calculates the compression percentage based on the original size and the compressed size
 */
fun calculateCompressionPercentage(originalSize: Int, compressedSize: Int): Double {
    val compressionPercentage = (1.0 - compressedSize.toDouble() / originalSize) * 100
    return "%.2f".format(compressionPercentage).toDouble()
}