import kotlin.system.measureTimeMillis

fun main() {
    val sort = Sort()
    val listSizes = listOf(100, 1000, 10000, 100000, 1000000)

    println("=================================================================")
    println("List Size | Heap Sort | Insertion Sort | Bucket Sort | Quick Sort")
    println("=================================================================")

    for (size in listSizes) {
        val list = generateRandomIntArray(size)
        val heapSortTime = measureTimeMillis { sort.heapSort(list.copyOf()) }
        val insertionSortTime = measureTimeMillis { sort.insertionSort(list.copyOf()) }
        val bucketSortTime = measureTimeMillis { sort.bucketSort(list.copyOf()) }
        val quickSortTime = measureTimeMillis { sort.quickSort(list.copyOf()) }

        println("$size\t\t| $heapSortTime ms | $insertionSortTime ms | $bucketSortTime ms | $quickSortTime ms")
    }
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
