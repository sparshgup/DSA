/**
 * LempelZiv LZ78 variant implementation for lossless data compression.
 *
 * Source: https://math.mit.edu/~djk/18.310/Lecture-Notes/LZ-worst-case.pdf
 */
class LempelZiv {

    /**
     * Encodes the input string using the algorithm.
     *
     * @param input The input string to be encoded.
     * @return A list of pairs representing the encoded data, where each pair contains an integer
     * encoding and the corresponding character.
     */
    fun encode(input: String): List<Pair<Int, Char>> {
        val dictionary = AssociativeArray<String, Int>()
        val result = mutableListOf<Pair<Int, Char>>()
        var nextEncoding = 1

        var current = ""
        for (char in input) {
            val new = current + char;
            if (dictionary.contains(new)) {
                current = new
            } else {
                // get encoding of current phrase
                val encoding = dictionary[current] ?: 0
                // add new encoded pair to result
                result.add(encoding to char)
                // add new encoded pair to dict
                dictionary[new] = nextEncoding++
                // reset current phrase
                current = ""
            }
        }
        return result
    }

    /**
     * Decodes the input list of encoded pairs using the algorithm.
     *
     * @param input The list of pairs representing the encoded data, where each pair contains an integer
     * encoding and the corresponding character.
     * @return The decoded string.
     */
    fun decode(input: List<Pair<Int, Char>>): String {
        val dictionary = AssociativeArray<Int, String>()
        val result = StringBuilder()
        var nextEncoding = 1

        for ((encoding, char) in input) {
            val phrase = if (encoding == 0) "" else dictionary[encoding] ?: throw IllegalStateException("Invalid data!")
            result.append(phrase).append(char)
            // stop decoding when we encounter stop code '#'
            if (char == '#') {
                break
            }
            // add new decoded phrase to dict
            dictionary[nextEncoding++] = phrase + char
        }
        return result.toString()
    }
}