package CH10;

import java.util.*;

/****************** Exercise 7 *****************
 * Create a class and make an initialized array
 * of your class objects. Fill a List from
 * your array. Create a subset of your List using
 * subList(), then remove this subset from
* your List.
 ***********************************************/
class IDClass{
	private static int counter;
	private int count=counter++;
	public String toString(){
		return "IDClass "+ count;
	}
}

public class E07_TestList{
	public static void main(String[] args){
		IDClass[] idc = new IDClass[10];
		for(int i=0; i<idc.length; i++)
			idc[i]= new IDClass();
		List<IDClass> lst = new ArrayList<IDClass>(Arrays.asList(idc));
		System.out.println("lst = " + lst);
		
		List<IDClass> subSet= lst.subList(lst.size()/4,lst.size()/2);
		System.out.println("subSet = "+subSet);
		//lst.removeAll(subSet);
		subSet.clear();
		System.out.println("lst = " + lst);
	}
}



























