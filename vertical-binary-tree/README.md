Question :

// Construct the tree:
//       1
//      / \
//     2   3
//    / \ / \
//   4  5 6  7
//
// Expected output: [[4], [2], [1, 5, 6], [3], [7]]
------------------------------------------------------------------------
Here's how you can implement vertical order traversal of a binary tree in Java, using Streams to help with sorting and processing the map entries.

**Steps**:

1- **Define TreeNode Class**:

    * Use a simple TreeNode class to represent each node in the tree.

2- **BFS Traversal**:

    * Use a Queue to store each node along with its horizontal distance (HD).
    * Store nodes by HD in a Map<Integer, List<Integer>>.

3- **Sorting with Streams**:

    * Sort the map entries by HD using Java Streams.
    * Use Streams to transform the sorted entries into a list of lists for output.
------------------------------------------------------------------------
**Explanation**

**Map Structure**: 
 * verticalMap holds the nodes for each horizontal distance as a list of integers.

**Pair Class**: 
* A helper class, Pair, is used to store each TreeNode along with its horizontal distance in the Queue.

**BFS Traversal**:
* Each node is dequeued, and its value is added to the list corresponding to its horizontal distance.
Left and right children are enqueued with updated horizontal distances.

**Sorting with Streams**:

* We sort verticalMap by its keys (horizontal distances).
Use map(Map.Entry::getValue) to extract the lists of node values in sorted order and collect them as a List<List<Integer>>.

------------------------------------------------------------------------
Happy coding!

LinkedIn: https://www.linkedin.com/in/saber-pourmomen

Email: saber.pourmomen@gmail.com