/**
 * Represents a square matrix of size n x n.
 * Supports matrix multiplication and manipulation functions.
 * @property n The size of the square matrix.
 * @property matrix The two-dimensional array representing the elements of the matrix.
 * @constructor Creates a Matrix of size 'n' initialized with all elements set to 0.0.
 */

class Matrix (private val n: Int) {
    val matrix: Array<Array<Double>> = Array(n) {Array(n) { 0.0 } }

    init {
        require (n > 0) {"Matrix size cannot be 0!"}
    }

    /**
     * Sets the value of the element at the specified row and column.
     * @param row The row index.
     * @param col The column index.
     * @param value The value to set.
     * @throws IllegalArgumentException if the row or column index is out of bounds.
     */
    fun setValue(row: Int, col: Int, value: Double) {
        checkIndexExists(row, col)
        matrix[row][col] = value
    }

    /**
     * Retrieves the value of the element at the specified row and column.
     * @param row The row index.
     * @param col The column index.
     * @return The value of the element at the specified position.
     * @throws IllegalArgumentException if the row or column index is out of bounds.
     */
    fun getElement(row: Int, col: Int): Double {
        checkIndexExists(row, col)
        return matrix[row][col]
    }

    /**
     * Checks if the given row and column indices are within bounds of the matrix.
     * @param row The row index.
     * @param col The column index.
     * @throws IllegalArgumentException if the row or column index is out of bounds.
     */
    private fun checkIndexExists(row: Int, col: Int) {
        require (row in 0 until n) {"row index out of bounds!"}
        require (col in 0 until n) {"column index out of bounds!"}
    }

    /**
     * Multiply [this] matrix by [other].
     * Implements the traditional matrix multiplication algorithm which has cubic time complexity.
     * @param other The matrix to multiply with.
     * @return [this]*[other] if the dimensions are compatible and null otherwise
     */
    fun multiply(other: Matrix):Matrix? {
        if (n != other.n) return null // null if size mismatch

        val result = Matrix(n)
        for (i in 0 until n) {
            for (j in 0 until n) {
                var sum = 0.0
                for (k in 0 until n) {
                    sum += matrix[i][k] * other.matrix[k][j]
                }
                result.matrix[i][j] = sum
            }
        }
        return result
    }


    /**
     * Multiply [this] matrix by [other].
     * Calls the recursive Strassen's Multiplication algorithm.
     * @param other The matrix to multiply with.
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

    /**
     * Implements the Strassen's Multiplication algorithm with lesser than cubic time complexity.
     * @param a the first input matrix to be multiplied
     * @param b the second input matrix to be multiplied
     * @param c the resultant matrix after matrix multiplication
     * @param n the size of the matrices
     */
    private fun strassenMultiplyRecursive(a: Matrix, b: Matrix, c: Matrix, n: Int) {

        // Base case //
        if (n == 1) {
            val value = a.getElement(0, 0) * b.getElement(0, 0)
            c.setValue(0, 0, value)
            return
        }

        // Recursive Case //
        val newSize = n / 2

        // initialize sub-matrices
        val a11 = Matrix(newSize)
        val a12 = Matrix(newSize)
        val a21 = Matrix(newSize)
        val a22 = Matrix(newSize)
        val b11 = Matrix(newSize)
        val b12 = Matrix(newSize)
        val b21 = Matrix(newSize)
        val b22 = Matrix(newSize)
        val c11 = Matrix(newSize)
        val c12 = Matrix(newSize)
        val c21 = Matrix(newSize)
        val c22 = Matrix(newSize)

        // populate sub-matrices
        splitMatrix(a, a11, 0, 0)
        splitMatrix(a, a12, 0, newSize)
        splitMatrix(a, a21, newSize, 0)
        splitMatrix(a, a22, newSize, newSize)
        splitMatrix(b, b11, 0, 0)
        splitMatrix(b, b12, 0, newSize)
        splitMatrix(b, b21, newSize, 0)
        splitMatrix(b, b22, newSize, newSize)

        // initialize new intermediate matrices
        val m1 = Matrix(newSize)
        val m2 = Matrix(newSize)
        val m3 = Matrix(newSize)
        val m4 = Matrix(newSize)
        val m5 = Matrix(newSize)
        val m6 = Matrix(newSize)
        val m7 = Matrix(newSize)

        // temporary matrices for algorithm calculations
        val temp1 = Matrix(newSize)
        val temp2 = Matrix(newSize)

        // Apply Strassen's algorithm

        // M1 = (A11 + A22) x (B11 + B22)
        addMatrices(a11, a22, temp1)
        addMatrices(b11, b22, temp2)
        strassenMultiplyRecursive(temp1, temp2, m1, newSize)

        // M2 = (A21 + A22) x B11
        addMatrices(a21, a22, temp1)
        strassenMultiplyRecursive(temp1, b11, m2, newSize)

        // M3 = A11 x (B12 - B22)
        subtractMatrices(b12, b22, temp2)
        strassenMultiplyRecursive(a11, temp2, m3, newSize)

        // M4 = A22 x (B21 - B11)
        subtractMatrices(b21, b11, temp2)
        strassenMultiplyRecursive(a22, temp2, m4, newSize)

        // M5 = (A11 + A12) x B22
        addMatrices(a11, a12, temp1)
        strassenMultiplyRecursive(temp1, b22, m5, newSize)

        // M6 = (A21 - A11) x (B11 + B12)
        subtractMatrices(a21, a11, temp1)
        addMatrices(b11, b12, temp2)
        strassenMultiplyRecursive(temp1, temp2, m6, newSize)

        // M7 = (A12 - A22) x (B21 + B22)
        subtractMatrices(a12, a22, temp1)
        addMatrices(b21, b22, temp2)
        strassenMultiplyRecursive(temp1, temp2, m7, newSize)

        // combine sub-matrix results

        // C11 = M1 + M4 - M5 + M7
        addMatrices(m1, m4, temp1)
        subtractMatrices(temp1, m5, temp2)
        addMatrices(temp2, m7, c11)

        // C12 = M3 + M5
        addMatrices(m3, m5, c12)

        // C21 = M2 + M4
        addMatrices(m2, m4, c21)

        // C22 = M1 - M2 + M3 + M6
        subtractMatrices(m1, m2, temp1)
        addMatrices(m3, m6, temp2)
        addMatrices(temp1, temp2, c22)

        // combine matrices to obtain result matrix C
        combineMatrices(c11, c12, c21, c22, c)
    }

    /**
     * Splits the parent matrix into a child matrix starting at the specified row and column.
     * @param parent The parent matrix to split.
     * @param child The child matrix to store the split elements.
     * @param row The starting row index.
     * @param col The starting column index.
     */
    private fun splitMatrix(parent: Matrix, child: Matrix, row: Int, col: Int) {
        for (i in 0 until child.n) {
            for (j in 0 until child.n) {
                child.setValue(i, j, parent.getElement( row + i, col + j))
            }
        }
    }

    /**
     * Adds two matrices element-wise and stores the result in the 'result' matrix.
     * @param mat1 The first matrix to add.
     * @param mat2 The second matrix to add.
     * @param result The matrix to store the result.
     */
    private fun addMatrices(mat1: Matrix, mat2: Matrix, result: Matrix) {
        val n = mat1.n
        for (i in 0 until n) {
            for (j in 0 until n) {
                result.setValue(i, j, mat1.getElement(i, j) + mat2.getElement(i, j))
            }
        }
    }

    /**
     * Subtracts one matrix from another element-wise and stores the result in the 'result' matrix.
     * @param mat1 The matrix to subtract from.
     * @param mat2 The matrix to subtract.
     * @param result The matrix to store the result.
     */
    private fun subtractMatrices(mat1: Matrix, mat2: Matrix, result: Matrix) {
        val n = mat1.n
        for (i in 0 until n) {
            for (j in 0 until n) {
                result.setValue(i, j, mat1.getElement(i, j) - mat2.getElement(i, j))
            }
        }
    }

    /**
     * Combines four sub-matrices into a single matrix.
     * @param c11 The top-left sub-matrix.
     * @param c12 The top-right sub-matrix.
     * @param c21 The bottom-left sub-matrix.
     * @param c22 The bottom-right sub-matrix.
     * @param c The matrix to store the combined result.
     */
    private fun combineMatrices(
        c11: Matrix, c12: Matrix, c21: Matrix, c22: Matrix, c: Matrix
    ) {
        val n = c11.n
        for (i in 0 until n) {
            for (j in 0 until n) {
                c.setValue(i, j, c11.getElement(i, j))
                c.setValue(i, j + n, c12.getElement(i, j))
                c.setValue(i + n, j, c21.getElement(i, j))
                c.setValue(i + n, j + n, c22.getElement(i, j))
            }
        }
    }

    /**
     * Checks if the given integer is a power of two.
     * @param n The integer to check.
     * @return true if the integer is a power of two, false otherwise.
     */
    private fun isPowerOfTwo(n: Int): Boolean {
        return n > 0 && (n and (n - 1)) == 0
    }
}