# Assignment 4: Sorting

## Sorting Algorithm Implementation and Complexity Analysis

- **Heap Sort:** The algorithm requires building a heap from an array by inserting elements
which takes *O(n)* time. Then, the extractMin() function is called *n* times to perform the sorting, and it requires *log n*
time each time because that is the height of a binary tree. Therefore, in total, in all cases, heap sort
takes *O(n log n)* time complexity to run.


- **Insertion Sort:** For the best case, where the input array is already sorted, it has a *O(n)* time complexity. 
However, for the average case and worst case inputs, every iteration of the algorithm scans and shifts the entire subsection of the array
before inserting the next element which results in a quadratic time complexity *O(n^2)*.


- **Merge Sort:** For splitting a binary tree into half again and again, we take a time complexity of *O(log n)*.
To merge the subarrays, it takes *O(n)* running time and, therefore, in all cases, the total time complexity of 
merge sort is *O(n log n)*.


- **Quick Sort:** In the average case and best case possibilities (where the pivot element is in the middle or the list is jumbled),
the quick sort algorithm handles the partitioning, etc. in a time complexity of *O(n log n)* due to the divide-and-conquer approach. 
In the worst case scenario (where the pivot element is on one of the ends of the array), the time complexity becomes *O(n^2).*

## Sorting Algorithm Benchmarking

### Runtime Results (approx.)

| List Size | Heap Sort | Insertion Sort | Merge Sort | Quick Sort |
|-----------|-----------|----------------|------------|------------|
| 100       | < 1 ms    | < 1 ms         | < 1 ms     | < 1 ms     |
| 1000      | < 1 ms    | < 1 ms         | < 1 ms     | < 1 ms     |
| 10000     | 6 ms      | 5 ms           | < 1 ms     | < 1 ms     |
| 100000    | 94 ms     | 441 ms         | 9 ms       | 5 ms       |
| 1000000   | 1827 ms   | 46114 ms       | 101 ms     | 63 ms      |

### Testing the algorithms

- The sorting algorithms are tested with multiple different list sizes.
- The lists (IntArray) are generated randomly. 
- The four sorting algorithms are performed for 10 runs each on each distinct list size.
- The average runtime (in milliseconds) across these runs is measured for more accurate results. 

###  Conclusions

- For small lists (100 and 1000 elements), all algorithms perform very fast, taking less than 1 millisecond.
- As the list size increases, performance differences is more observable.
- Merge Sort and Quick Sort outperform Insertion Sort and Heap Sort for larger lists quite evidently. 
In general, they are also faster for any list size.
- However, Insertion Sort is generally bad for larger lists as evident by its time complexity, but is also 
considered comparatively faster for small lists.


## New Frontiers in Sorting?

Some problems/areas in the field of sorting:

- Most sorting in the real-world requires sorting on multiple variables rather than just one-value which is performed by the above implemented algorithms.
- Sorting on large-scale and distributed data is a challenge as these are massive and partitioned.
- Graph-sampling algorithms have many applications where connections are modeled as graphs.

### Research paper

Mankowitz, D.J., Michi, A., Zhernov, A. et al. Faster sorting algorithms discovered using deep reinforcement learning. Nature 618, 257–263 (2023). https://doi.org/10.1038/s41586-023-06004-9

**Key Ideas:**

- The research uses deep reinforcement learning to optimize sorting algorithms, looking at the problem as a single-player game.
- The algorithms are based upon simple divide-and-conquer algorithms such as fixed sort and variable sort.
- Essentially, making guesses at each stage of sorting by using the ML knowledge and creating a more efficient overall sorting algorithm.

**Approach:**

- The learning algorithm is based on an extension of the AlphaZero agent 
and utilizes Monte Carlo tree search in combination with a deep neural network.
- AlphaDev's representation network consists of a transformer encoder and a CPU state
encoder which efficiently explores the space of instructions and represents complex algorithmic structures.
- It optimizes for both correctness and latency, with a dual value function setup predicting algorithm correctness and latency separately.

**Conclusions:**

- AlphaDev discovers new state-of-the-art sorting algorithms from scratch that outperform existing human benchmarks.
- The discovered algorithms have been integrated into the LLVM C++ library, which is very popularly used.
- The algorithm could be easily generalized to other domains.


## Master Theorem

The solved worksheet is at: [mastertheorem_worksheet.pdf](mastertheorem_worksheet.pdf)

Used this resource as a guide for master theorem: https://web.stanford.edu/class/archive/cs/cs161/cs161.1168/lecture3.pdf
