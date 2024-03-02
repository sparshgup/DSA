fun main() {
    val sizes = intArrayOf(64, 128, 256, 512, 1024)
    val iterations = 10

    println("Matrix Size\tTraditional (ms)\tStrassen (ms)")
    for (size in sizes) {
        var traditionalTotalTime = 0L
        var strassenTotalTime = 0L

        for (i in 0 until iterations) {
            val matrixA = generateRandomMatrix(size)
            val matrixB = generateRandomMatrix(size)

            val startTime = System.currentTimeMillis()
            val traditionalResult = matrixA.multiply(matrixB)
            val traditionalEndTime = System.currentTimeMillis()

            val strassenStartTime = System.currentTimeMillis()
            val strassenResult = matrixA.strassenMultiply(matrixB)
            val strassenEndTime = System.currentTimeMillis()

            traditionalTotalTime += traditionalEndTime - startTime
            strassenTotalTime += strassenEndTime - strassenStartTime
        }

        val traditionalAverageTime = traditionalTotalTime.toDouble() / iterations
        val strassenAverageTime = strassenTotalTime.toDouble() / iterations

        println("$size\t\t\t$traditionalAverageTime\t\t\t\t\t$strassenAverageTime")
    }
}

// Generate a random matrix
fun generateRandomMatrix(size: Int): Matrix {
    val matrix = Matrix(size)
    val random = java.util.Random()
    for (i in 0 until size) {
        for (j in 0 until size) {
            matrix.setValue(i, j, random.nextDouble())
        }
    }
    return matrix
}
