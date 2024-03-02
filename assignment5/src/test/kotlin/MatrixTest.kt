import org.junit.jupiter.api.Test
import kotlin.test.*
import org.junit.jupiter.api.Assertions.*

class MatrixTest {

    @Test
    fun testInitializedGetElement() {
        val matrix = Matrix(2)
        assertEquals(matrix.getElement(0, 0), 0.0)
        assertEquals(matrix.getElement(0, 1), 0.0)
        assertEquals(matrix.getElement(1, 0), 0.0)
        assertEquals(matrix.getElement(1, 1), 0.0)
    }
    @Test
    fun testSetValueGetElement() {
        val matrix = Matrix(2)
        matrix.setValue(0, 0, 3.1)
        matrix.setValue(0, 1, 5.5)
        matrix.setValue(1, 0, 4.8)
        matrix.setValue(1, 1, 2.3)
        assertEquals(matrix.getElement(0, 0), 3.1)
        assertEquals(matrix.getElement(0, 1), 5.5)
        assertEquals(matrix.getElement(1, 0), 4.8)
        assertEquals(matrix.getElement(1, 1), 2.3)
    }

    @Test
    fun multiply() {
        val matrix1 = Matrix(2)
        val matrix2 = Matrix(2)

        // Initialize matrices with values
        matrix1.setValue(0, 0, 1.0)
        matrix1.setValue(0, 1, 2.0)
        matrix1.setValue(1, 0, 3.0)
        matrix1.setValue(1, 1, 4.0)

        matrix2.setValue(0, 0, 5.0)
        matrix2.setValue(0, 1, 6.0)
        matrix2.setValue(1, 0, 7.0)
        matrix2.setValue(1, 1, 8.0)

        // Expected result of multiplication
        val expectedResult = Matrix(2)
        expectedResult.setValue(0, 0, 19.0)
        expectedResult.setValue(0, 1, 22.0)
        expectedResult.setValue(1, 0, 43.0)
        expectedResult.setValue(1, 1, 50.0)

        // Perform multiplication
        val result = matrix1.multiply(matrix2)

        // Check if the result matches the expected result
        assertNotNull(result)
        for (i in 0 until 2) {
            for (j in 0 until 2) {
                assertEquals(expectedResult.getElement(i, j), result!!.getElement(i, j))
            }
        }
    }

    @Test
    fun strassenMultiply() {
        val matrix1 = Matrix(2)
        val matrix2 = Matrix(2)

        // Initialize matrices with values
        matrix1.setValue(0, 0, 1.0)
        matrix1.setValue(0, 1, 2.0)
        matrix1.setValue(1, 0, 3.0)
        matrix1.setValue(1, 1, 4.0)

        matrix2.setValue(0, 0, 5.0)
        matrix2.setValue(0, 1, 6.0)
        matrix2.setValue(1, 0, 7.0)
        matrix2.setValue(1, 1, 8.0)

        // Expected result of multiplication
        val expectedResult = Matrix(2)
        expectedResult.setValue(0, 0, 19.0)
        expectedResult.setValue(0, 1, 22.0)
        expectedResult.setValue(1, 0, 43.0)
        expectedResult.setValue(1, 1, 50.0)

        // Perform multiplication using Strassen's algorithm
        val result = matrix1.strassenMultiply(matrix2)

        // Check if the result matches the expected result
        assertNotNull(result)
        for (i in 0 until 2) {
            for (j in 0 until 2) {
                assertEquals(expectedResult.getElement(i, j), result!!.getElement(i, j))
            }
        }
    }
}