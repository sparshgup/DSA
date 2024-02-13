/**
 * A class that implements the following sorting algorithms:
 *  - Heap Sort
 *  - Insertion Sort
 *  - Bucket Sort
 *  - Quick Sort
 *
 * Source used: Introduction to Algorithms, CLRS
 */
class Sort {

    /**
     * Sorts the given array using the Heap Sort algorithm.
     * Time Complexity: O(n log n)
     *
     * @param arr The array to be sorted.
     */
    fun heapSort(arr: IntArray) {
        // use a binary min-heap
        val heap = MinHeap<Int>()
        // insert elements into the heap
        for (elem in arr) {
            heap.insert(elem, elem.toDouble())
        }
        // extract elements from heap to sort the array
        for (i in arr.indices) {
            arr[i] = heap.extractMin()!!
        }
    }

    /**
     * Sorts the given array using the Insertion Sort algorithm.
     * Time Complexity: O(n^2)
     *
     * @param arr The array to be sorted.
     */
    fun insertionSort(arr: IntArray) {
        for (j in 1 until arr.size) {
            val key = arr[j]
            var i = j - 1
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i]
                i--
            }
            arr[i + 1] = key
        }
    }

    /**
     * Sorts the given array using the Bucket Sort algorithm.
     * Time Complexity: O(n + k), where n is the number of elements and k is the number of buckets.
     *
     * @param arr The array to be sorted.
     */
    fun bucketSort(arr: IntArray){
        val n = arr.size
        val sortedArr = IntArray(n)

        // create buckets
        val buckets = Array<MutableList<Int>>(n) { mutableListOf() }

        // add elements to buckets
        for (i in 0 until n) {
            val j = arr[i]
            buckets[j].add(arr[i])
        }

        // sort each bucket using InsertionSort
        for (bucket in buckets) {
            insertionSort(bucket.toIntArray())
        }

        // concatenate the bucket lists
        var index = 0
        for (bucket in buckets) {
            for (element in bucket) {
                arr[index++] = element
            }
        }
    }

    /**
     * Sorts the given array using the Quick Sort algorithm.
     * Time Complexity: O(n log n) on average, O(n^2) worst case.
     *
     * @param arr The array to be sorted.
     */
    fun quickSort(arr: IntArray) {
        helperQuickSort(arr, 0, arr.size - 1)
    }

    /**
     * The actual Quick Sort algorithm implementation as a helper function.
     *
     * @param arr The array to be sorted.
     * @param p The starting index of the subarray to be sorted.
     * @param r The ending index of the subarray to be sorted.
     */
    private fun helperQuickSort(arr: IntArray, p: Int, r: Int) {
        if (p < r) {
            val q = partition(arr, p, r)
            helperQuickSort(arr, p, q - 1)
            helperQuickSort(arr, q + 1, r)
        }
    }

    /**
     * Partitions the array for the Quick Sort algorithm.
     *
     * @param arr The array to be partitioned.
     * @param p The starting index of the subarray to be partitioned.
     * @param r The ending index of the subarray to be partitioned.
     * @return The index of the pivot element after partitioning.
     */
    private fun partition(arr: IntArray, p: Int, r: Int): Int {
        val x = arr[r]
        var i = p - 1
        for (j in p until r) {
            if (arr[j] <= x) {
                i++
                swap(arr, i, j)
            }
        }
        swap(arr, i + 1, r)
        return i + 1
    }

    /**
     * Swaps two elements in the array for the Quick Sort algorithm.
     *
     * @param arr The array containing the elements.
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}