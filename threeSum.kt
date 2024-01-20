// threeSum //
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0


// Kotlin code for threeSum program //
fun threeSum(nums: List<Int>): List<List<Int>> {

    // Sort the input list first
    val sortedNums = nums.sorted()

    // List to store triplets
    val triplets = mutableListOf<List<Int>>()

    // iterate through the sorted array
    for (i in 0..<sortedNums.size - 2) {

        // Skip duplicate elements
        if ((i > 0) and (sortedNums[i] == sortedNums[i - 1])) {
            continue
        }

        // Use two pointers (j & k) such that this pair sums to negative of current element (i)
        var j = i + 1
        var k = sortedNums.size - 1

        // execute loop until we exhaust the elements in array
        while (j < k) {

            // calculate the total sum
            val total = sortedNums[i] + sortedNums[j] + sortedNums[k]

            // conditional branches based on total sum
            when {
                total == 0 -> {
                    // desired condition: add list to triplets
                    triplets.add(listOf(sortedNums[i], sortedNums[j], sortedNums[k]))
                    // Skip duplicate elements
                    while ((j < k) and (sortedNums[j] == sortedNums[j + 1])) {
                        j++
                    }
                    while ((j < k) and (sortedNums[k] == sortedNums[k - 1])) {
                        k--
                    }
                    // Move pointers
                    j++
                    k--
                }
                total < 0 -> j++
                else -> k--
            }
        }
    }

    return triplets
}


// Python code for threeSum program //
/*
def threeSum(self, nums: List[int]) -> List[List[int]]:

        nums.sort()
        triplets = []

        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            j, k = i + 1, len(nums) - 1

            while j < k:

                total = nums[i] + nums[j] + nums[k]

                if total == 0:
                    triplets.append([nums[i], nums[j], nums[k]])
                    while j < k and nums[j] == nums[j + 1]:
                        j += 1
                    while j < k and nums[k] == nums[k - 1]:
                        k -= 1
                    j += 1
                    k -= 1

                elif total < 0:
                    j += 1

                else:
                    k -= 1

        return triplets
 */