class Matrix (private val n: Int) {
    private val matrix: Array<Array<Double>> = Array(n) {Array(n) { 0.0 } }

    init {
        require (n > 0) {"Matrix size cannot be 0!"}
    }

    fun setValue(row: Int, col: Int, value: Double) {
        checkIndexExists(row, col)
        matrix[row][col] = value
    }

    fun getElement(row: Int, col: Int): Double {
        checkIndexExists(row, col)
        return matrix[row][col]
    }

    private fun checkIndexExists(row: Int, col: Int) {
        require (row in 0 until n) {"row index out of bounds!"}
        require (col in 0 until n) {"column index out of bounds!"}
    }

    /**
     * Multiply [this] matrix by [other].
     * You can implement this either using block-based matrix multiplication or
     * traditional matrix multiplication (the kind you learn about in math
     * classes!)
     * @return [this]*[other] if the dimensions are compatible and null otherwise
     */
    fun multiply(other: Matrix):Matrix? {
        if (n != other.n) return null // null if size mismatch

        val result = Matrix(n)
        for (i in 0 until n) {
            for (j in 0 until n) {
                var sum = 0.0
                for (k in 0 until n) {
                    sum = matrix[i][j] * other.matrix[j][k]
                }
                result.matrix[i][j] = sum
            }
        }
        return result
    }


    /**
     * Multiply [this] matrix by [other].
     * Your code should use Strassen's algorithm
     * @return [this]*[other] if the dimensions are compatible and null otherwise
     */
    fun strassenMultiply(other: Matrix):Matrix? {
        if (n != other.n) return null // null if size mismatch

        // n should be a power of 2 condition for Strassen's algorithm
        require (isPowerOfTwo(n)) {"n is not a power of 2!"}

        val result = Matrix(n)
        strassenMultiplyRecursive(this, other, result, n)
        return result
    }

    private fun strassenMultiplyRecursive(A: Matrix, B: Matrix, C: Matrix, n: Int) {
        // Base case
        if (n == 1) {
            val value = A.getElement(0, 0) * B.getElement(0, 0)
            C.setValue(0, 0, value)
            return
        }

        // Recursive Case

    }

    private fun isPowerOfTwo(n: Int): Boolean {
        return n > 0 && (n and (n - 1)) == 0
    }
}