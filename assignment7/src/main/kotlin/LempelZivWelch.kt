/**
 * Lempel-Ziv-Welch (LZW) compression algorithm implementation.
 */
class LempelZivWelch {

    private val dictionary = AssociativeArray<String, Int>()

    init {
        // Initialize the dictionary with single character strings
        for (i in 0..255) {
            dictionary[i.toChar().toString()] = i
        }
    }

    /**
     * Compresses the input string using the LZW algorithm.
     * @param input The input string to be compressed.
     * @return The list of compressed codes representing the input string.
     */
    fun compress(input: String): List<Int> {
        var currentSubstring = input[0].toString()
        val output = mutableListOf<Int>()

        for (i in 1 until input.length) {
            val nextChar = input[i]
            val newSubstring = currentSubstring + nextChar
            if (dictionary.contains(newSubstring)) {
                currentSubstring = newSubstring
            } else {
                output.add(dictionary[currentSubstring]!!)
                dictionary[newSubstring] = dictionary.size()
                currentSubstring = nextChar.toString()
            }
        }

        output.add(dictionary[currentSubstring]!!)

        return output
    }
}
