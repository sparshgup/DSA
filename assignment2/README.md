# Assignment 2

### P1 and P2

The source code is present in `~/src/main/kotlin/`.

The unit tests are present in `~/src/test/kotlin/`.

### P3

- We can use a temporary queue (which follows FIFO) to reverse a stack (which follows LIFO) by pushing all stack elements to the queue, and the pushing them back to the original stack.
- For example, consider `Stack(1, 2, 3, 4, 5)` in the order of top to bottom.
- Now, let us initialize a `Queue()`. 
- Pop the front element `1` of Stack, and then enqueue it to obtain `Queue(1)`.
- We do the same again for the `Stack(2, 3, 4, 5)` where the front element `2` is popped and enqueued in the Queue to get `Queue(1, 2)`.
- Repeating this process, we get to the stage where the original stack is now empty (`Stack()`) and we also have `Queue(1, 2, 3, 4, 5)`.
- Now, we dequeue our current `Queue(1, 2, 3, 4, 5)` to pop the front element `1`. We then push this element to our original stack which is now `Stack(1)`.
- We do the same again and we dequeue `Queue(2, 3, 4, 5)` where the front element `2` is now popped, and we push this element to our stack to now obtain `Stack(2, 1)`.
- We keep repeating this process until we have no elements left in the Queue, and we have pushed all the elements into our stack.
- Therefore, we get `Stack(5, 4, 3, 2, 1)` and we can see that the elements have been reversed in the original stack.

### P4

Implementation: The source code is present in `~/src/main/kotlin/`. The unit tests are present in `~/src/test/kotlin/`.

- This problem can simply be solved using a stack of Char type.
- We input the string of parentheses to the stack. 
- Then, we initialize a for loop which goes through the characters in the string.
- Using conditionals, whenever we encounter an opening parenthesis, we push it to the stack.
- Whenever we encounter a closing parenthesis, we check whether the stack is empty and if it is, we instantly return false because we only had one mis-matching closing parenthesis left in the stack. 
If that is not the case, we pop the stack and check whether the popped element is a matching opening parenthesis. If it is not, we return false.
- We keep on going through the loop until we exhaust the string and have popped all elements in the stack. 
- Therefore, if we have obtained an empty stack, it means that the parentheses string was valid, and we finally would return true by using the isEmpty() function of the stack.

### P5

- Let's say we have two stacks: S1 (the original stack) & S2 (the new stack) and we have one queue Q for auxiliary storage.
- We start with popping elements one-by-one from the front in S1 and pushing them in the front one-by-one into S2 until S1 is empty. This will move all the elements to S2 in a reversed order.
- Now, we start popping the elements from the front one-by-one from S2 and we enqueue (add from the back) them one-by-one to the Q until S2 is empty. This will move all the elements to Q (they are still in the reversed order - same as S2).
- Then, we dequeue the elements (pop from the front) one-by-one from Q and then push them back to S2 one-by-one from the front. This will obtain the copied stack S2 in the original order of elements we had in S1 as desired.
