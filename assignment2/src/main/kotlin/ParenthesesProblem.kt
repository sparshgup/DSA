class ParenthesesProblem {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        // loop through the characters in the string
        for (char in s) {
            when (char) {
                // push to stack if it is an opening parenthesis
                '(', '{', '[' -> stack.push(char)
                // determine if a closing parenthesis is valid
                ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
                '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
                ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
            }
        }
        // return true if the stack is exhausted and the parentheses string is valid
        return stack.isEmpty()
    }
}