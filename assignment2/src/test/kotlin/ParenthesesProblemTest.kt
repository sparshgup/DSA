import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class ParenthesesProblemTest {

    @Test
    fun testValid() {
        val parentheses = ParenthesesProblem()
        assertTrue(parentheses.isValid("()"))
        assertTrue(parentheses.isValid("()[]{}"))
        assertTrue(parentheses.isValid("[{()}]"))
        assertTrue(parentheses.isValid("[()]{}"))
        assertTrue(parentheses.isValid(""))
    }

    @Test
    fun testInvalid() {
        val parentheses = ParenthesesProblem()
        assertFalse(parentheses.isValid("(]"))
        assertFalse(parentheses.isValid("{(})"))
        assertFalse(parentheses.isValid("(])"))
        assertFalse(parentheses.isValid("[[]"))
    }
}