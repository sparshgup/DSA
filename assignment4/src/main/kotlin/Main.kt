import kotlin.system.measureTimeMillis

fun main() {
    val sort = Sort()
    val listSizes = listOf(100, 1000, 10000, 100000, 1000000)

    println("===================================================================")
    println("List Size | Heap Sort | Insertion Sort | Merge Sort | Quick Sort |")
    println("===================================================================")

    for (size in listSizes) {
        val heapSortAvgTime = measureAverageTimeMillis(10) { sort.heapSort(generateRandomIntArray(size)) }
        val insertionSortAvgTime = measureAverageTimeMillis(10) { sort.insertionSort(generateRandomIntArray(size)) }
        val mergeSortAvgTime = measureAverageTimeMillis(10) { sort.mergeSort(generateRandomIntArray(size)) }
        val quickSortAvgTime = measureAverageTimeMillis(10) { sort.quickSort(generateRandomIntArray(size)) }

        println("$size\t\t| $heapSortAvgTime ms | $insertionSortAvgTime ms | $mergeSortAvgTime ms | $quickSortAvgTime ms |")
    }
}

/**
 * A function that averages the measured time (ms) over multiple runs.
 *
 * @param runs the number of runs.
 * @param block The block for which to measure the time (ms).
 * @return The average measured time (ms) over multiple runs.
 */
fun measureAverageTimeMillis(runs: Int, block: () -> Unit): Long {
    var totalTime = 0L
    repeat(runs) {
        totalTime += measureTimeMillis(block)
    }
    return totalTime / runs
}

/**
 * Generates a random IntArray of specified size.
 *
 * @param size the size of the IntArray to be generated.
 * @return a random IntArray of the specified size
 */
fun generateRandomIntArray(size: Int): IntArray {
    return IntArray(size) { it }.apply { shuffle() }
}
