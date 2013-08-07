package CH16;
/****************** Exercise 36 *****************
 * Modify SlowMap so that instead of two ArrayLists,
 * it holds a single ArrayList of MapEntry objects.
 * Verify that the modified version works correctly.
 * Using MapPerformance.java, test the speed of your
 * new Map. Now change the put() method so that it
 * performs a sort() after each pair is entered, and
 * modify get() to use Collections.binarySearch() to
 * look up the key. Compare the performance of the new
 * version with the old ones.
 ***********************************************/