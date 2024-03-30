# Assignment 7

## Lempel-Ziv-Welch Algorithm

I implemented the LZW algorithm to encode and compress data.

I tested out the compression algorithm on 3 different test cases which have commonly been used
to test the Lempel-Ziv algorithm. 

To benchmark the compression results, I utilized the following function which determines 
how smaller was the size of the compressed data and outputs a compression percentage:

**compression % = (1 - (compressed size / original size)) * 100%**

The following were the results:

| Test Case | Original                      | Encoded                                             | Compression % |
|-----------|-------------------------------|-----------------------------------------------------|---------------|
| 1         | AABABBBABAABABBBABBABB        | [65, 65, 66, 257, 66, 258, 258, 257, 259, 261, 265] | 50%           |
| 2         | TOBEORNOTTOBEORTOBEORNOT#    | [84, 79, 66, 69, ... 275, 269, 271, 273, 35]        | 32%           |
| 3         | HELLOHELLOHELLO#             | [72, 69, 76, 76, 79, 282, 284, 286, 283, 285, 35]   | 32%           |

The results indicate that the lossless LZW compression is highly useful because it compressed the original string sizes
by 32-50%. This indicates that the average compression % that we could estimate for this algorithm when 
applying it to any new string would be around or lower than ~50% for most strings depending on the specific string.