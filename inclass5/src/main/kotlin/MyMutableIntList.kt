package org.example

class MyMutableIntList {
    private var list = intArrayOf()
    private var actualListSize = 0

    /**
     * Add [element] to the end of the list
     */
    fun add(element: Int) {
        if (actualListSize >= list.size) {
            list = if (list.isEmpty())  {
                IntArray(1)
            } else {
                IntArray(list.size * 2)
            }
        }
        list[actualListSize] = element
        actualListSize += 1
    }

    /**
     * Remove all elements from the list
     */
    fun clear() {
        actualListSize = 0
    }

    /*
     * @return the size of the list
     */
    fun size(): Int {
        return actualListSize
    }

    /**
     * @param index the index to return
     * @return the element at [index]
     */
    operator fun get(index: Int):Int {
        return list[index]
    }

    /**
     * Store [value] at position [index]
     * @param index the index to set
     * @param value to store at [index]
     */
    operator fun set(index: Int, value: Int) {
        list[index] = value
    }
}