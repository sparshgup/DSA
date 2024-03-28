# Assignment 7

## Lempel-Ziv Algorithm

I implemented the LZ78 variant of the algorithm which compresses data by building
a string of data into a dictionary consisting of encoded "phrases". 

I tested out the compression algorithm on 3 different test cases which have commonly been used
to test the Lempel-Ziv algorithm. 

To benchmark the compression results, I utilized the following function which determines 
how smaller was the size of the compressed data and outputs a compression percentage:

**compression % = (1 - (compressed size / original size)) * 100%**

The following were the results:

| Test Case | Original                      | Encoded                                      | Decoded                      | Compression % |
|-----------|-------------------------------|----------------------------------------------|------------------------------|---------------|
| 1         | AABABBBABAABABBBABBABB        | [(0, A), (1, B), (2, B), (0, B), ... (9, B)] | AABABBBABAABABBBABBABB      | 54.55%        |
| 2         | TOBEORNOTTOBEORTOBEORNOT#    | [(0, T), (0, O), (0, B), (0, E), ... (1, #)] | TOBEORNOTTOBEORTOBEORNOT#  | 40.0%         |
| 3         | HELLOHELLOHELLO#             | [(0, H), (0, E), (0, L), (3, O), ... (4, #)] | HELLOHELLOHELLO#           | 40.0%         |

The results indicate that the lossless LZ78 compression is highly useful because it compressed the original string sizes
by 40% - 54.55%. This indicates that the average compression % that we could estimate for this algorithm when 
applying it to any new string would roughly be around ~ 50% or lesser than that depending on the specific string.