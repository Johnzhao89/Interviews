package Others;
import java.util.*;


import java.util.ArrayList;
import java.util.HashMap;


class Solution {
    public int solution(int K, int[] A) {
        // write your code here...
        HashMap<Integer,ArrayList<Integer>> map =  new HashMap<Integer,ArrayList<Integer>>();
        
        int dup=0,nonDup=0;
        for (int i=0;i< A.length;i++){
            if(2*A[i]==K){
                if(!map.containsKey(A[i])){
                    dup++;
                    map.put(A[i],new ArrayList<Integer>());
                }
                continue;
            }
            
            if(!map.containsKey(A[i])){
            	map.put(A[i],new ArrayList<Integer>());
            }
            map.get(A[i]).add(i);
            nonDup+=map.get(K-A[i]).size();
        }
        return nonDup*2+dup;
    }
    
}