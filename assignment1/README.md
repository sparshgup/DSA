# Assignment 1

## Hello Kotlin!

**1. What features do you like about Kotlin?**

- The type inference is a good thing to have in Kotlin.
- The extension functions are such a nice thing and reduces effort.
- We can easily leverage existing Java libraries.
- Removes the need for explicit casting.
- `when` for having conditional branches is very thoughtful.
- The single-expression function is a little thing but would simplify so much code.
- Data classes would be very helpful when using classes for custom data types.
- I have seen programming languages have problems with null pointer exceptions, and it is handled elegantly
  in Kotlin so that developers can avoid having them.

**2. Are there things you were expecting to find that you haven’t?**

- The conditional expression syntax is similar to C/C++ so was also expecting a similar format for ternary operator `condition ? then : else` but it is different (could be debated that it is more intuitive in Kotlin).
- Although I haven't worked with Java, I was expecting the syntax to be very much like it. However, it looks to me like that certain things have syntax that looks like a combination of Java, C, and, surprisingly, Haskell.

**3. What questions do you have?**

- I'm curious to know why Kotlin has both read-only and mutable types for Collections data types and what exactly would be the specific reasons or use-cases for this?

## Translating Code to Kotlin

I translated my old python code for the infamous **threeSum** program which is: *Given an integer array nums, 
return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0*.

The program source code is present in `~/src/main/kotlin/threeSum.kt`. 

The unit tests are present in `~/src/test/kotlin/ThreeSumTest.kt` and running this file executes the testing.

The purpose of the code is to find all such triplets in an integer array such that they sum up to 0. Also, the output should not have any duplicate triplet sets. 
The **threeSum** program, although seems not that important, has applications in network analysis, data analytics, financial modeling, and algorithm design.

The process of translating Python code to Kotlin was pretty good. 

- I liked that I was able to use the data-type *IntArray* for `nums` as an input to the program in Kotlin which 
reduces performance overhead and is more memory-efficient when compared to Python where it needs to a list of integers. However, Python lists offers more flexibility
as they are dynamic and their size can be modified unlike *IntArray*.
- It might be a personal opinion but defining whether a variable is read-only or mutable by using either `val` or `var` respectively is 
a little annoying.
- The in-built static *Type System* in Kotlin was helpful in not making careless errors involving type-mismatch. I faced this when I accidentally was using list of 
integers as an input to the Kotlin program and using the `.sort()` function on the input list. However, I realized that only works with *IntArray* and defining the type clearly was important in resolving that.
- Testing in Kotlin was pretty straightforward and easy, quite similar to how it is done in Python using *pytest*.
- A significant challenge I faced, unrelated to translating the code though, was to figure out how to set up the module for having code and testing it by utilizing gradle. 
I had to go through the Jetbrains documentation to finally understand it and set up the whole pipeline.