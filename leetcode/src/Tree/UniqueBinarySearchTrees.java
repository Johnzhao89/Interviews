package Tree;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
For example,
Given n = 3, there are a total of 5 unique BST's.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * @author heguangliu
 *
 */
import java.util.*;
public class UniqueBinarySearchTrees{
	public int numTrees(int n){
		return numTreesDP(1, n);
	}
	public int numTreesDP(int s, int e){
		if(s > e)
			return 1;
		if(s == e)
			return 1;
		int ret = 0;
		for(int i=s; i<=e; i++)
			ret+=numTreesDP(s, i-1)* numTreesDP(i+1, e);
		return ret;
	}
}