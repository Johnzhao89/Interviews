package OwnDS;

import java.io.*;

public class ArrayList<T> {
	protected int count;
	protected T[] contents;
	protected static int DEAFULT_CAPACITY = 10;

	public ArrayList() {
		contents = (T[]) new Object[DEAFULT_CAPACITY];
	}

	public ArrayList(int initCapacity) {
		contents = (T[]) new Object[initCapacity];
	}

	public void add(T newElem) {
		if (count == contents.length) {
			T[] temp = contents;
			contents = (T[]) new Object[2 * count];
			for (int i = 0; i < count; i++)
				contents[i] = temp[i];
		}
		contents[count++] = newElem;
	}

	public T get(int index) {
		if (index < 0 || index >= count)
			throw new IndexOutOfBoundsException("ArrayList:" + index);
		return contents[index];
	}

	public int size() {
		return count;
	}

	public T remove(int index) {
		if (index < 0 || index >= count)
			throw new IndexOutOfBoundsException("ArrayList:" + index);
		T temp = contents[index];
		for (int j = index; j < count - 1; j++)
			contents[j] = contents[j + 1];
		count--;
		return temp;
	}

	public int indexOf(T key) {
		for (int j = 0; j < count; j++)
			if (contents[j].equals(key))
				return j;
		return -1;
	}

	public String toString() {
		StringBuffer res = new StringBuffer("[");
		for (int i = 0; i < this.size() - 1; i++)
			res.append(this.get(i).toString()).append(",");
		return res.append(get(size() - 1).toString()).append("[").toString();
	}

	public static void main(String argu[]) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String line;
		ArrayList<String> v = new ArrayList<String>();
		while (sc.hasNext())
			v.add(sc.next());
		for (int i = v.size() - 1; i >= 0; i--)
			System.out.println(v.get(i));
		System.out.println(v);
	}

}