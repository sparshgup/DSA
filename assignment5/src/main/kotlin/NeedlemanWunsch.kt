/**
 * Needleman-Wunsch algorithm implementation for global sequence alignment.
 *
 * @param seqA The first sequence to be aligned.
 * @param seqB The second sequence to be aligned.
 * @param matchScore The score assigned for a match between two characters.
 * @param mismatchScore The score assigned for a mismatch between two characters.
 * @param gapScore The score penalizing the introduction of a gap in the alignment.
 */
class NeedlemanWunsch (
    private val seqA: String,
    private val seqB: String,
    private val matchScore: Int,
    private val mismatchScore: Int,
    private val gapScore: Int
)
{
    private val n: Int = seqA.length + 1
    private val m: Int = seqB.length + 1
    private val matrixF: Array<Array<Int>> = Array(n) {Array(m) { 0 } }

    init {
        computeMatrixF()
    }

    /**
     * Aligns the two sequences using the Needleman-Wunsch algorithm
     * and prints the aligned sequences.
     */
    fun alignSequences() {
        var alignmentA = ""
        var alignmentB = ""
        var i = seqA.length
        var j = seqB.length

        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 &&
                (matrixF[i][j] == matrixF[i-1][j-1] + score(seqA[i-1], seqB[j-1])))
            {
                alignmentA = seqA[i-1] + alignmentA
                alignmentB = seqB[j-1] + alignmentB
                i--
                j--
            }
            else if (i > 0 && (matrixF[i][j] == matrixF[i-1][j] + gapScore))
            {
                alignmentA = seqA[i-1] + alignmentA
                alignmentB = "-$alignmentB"
                i--
            }
            else
            {
                alignmentA = "-$alignmentA"
                alignmentB = seqB[j-1] + alignmentB
                j--
            }
        }
        println("Aligned sequence A: $alignmentA")
        println("Aligned sequence B: $alignmentB")
    }

    /**
     * Computes the F matrix which is the similarity matrix used for Needleman-Wunsch algorithm.
     */
    private fun computeMatrixF() {
        for (i in 0 until n) {
            matrixF[i][0] = gapScore * i
        }
        for (j in 0 until m) {
            matrixF[0][j] = gapScore * j
        }
        for (i in 1 until n) {
            for (j in 1 until m) {
                val match = matrixF[i-1][j-1] + score(seqA[i-1], seqB[j-1])
                val delete = matrixF[i-1][j] + gapScore
                val insert = matrixF[i][j-1] + gapScore
                matrixF[i][j] = maxOf(match, delete, insert)
            }
        }
    }

    private fun score(a: Char, b: Char): Int {
        return if (a == b) matchScore else mismatchScore
    }
}