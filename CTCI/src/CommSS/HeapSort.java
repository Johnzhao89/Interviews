package CommSS;

public class HeapSort extends AbstractSort {
	public void sort(int[] array) {
		heapify(array);
		for (int i = array.length - 1; i > 0; i--) {
			swap(array, 0, i);
			shiftDown(array, i - 1);
		}
	}

	// max heap
	private void heapify(int[] array) {
		for (int i = 1; i < array.length; i++) {
			shiftUp(array, i);
		}
	}

	private void shiftDown(int[] array, int end) {
		int temp = 0;
		while (temp * 2 + 1 <= end) {
			int leftChild = temp * 2 + 1;
			int rightChild = leftChild + 1;
			if (array[temp] < array[leftChild]) {
				if ((rightChild <= end)
						&& (array[leftChild] < array[rightChild])) {
					swap(array, temp, rightChild);
					temp = rightChild;
				} else {
					swap(array, temp, leftChild);
					temp = leftChild;

				}
			} else {
				if ((rightChild <= end) && (array[temp] < array[rightChild])) {
					swap(array, temp, rightChild);
					temp = rightChild;
				} else {
					break;
				}
			}
		}
	}

	private void shiftUp(int[] array, int index) {
		while (index != 0) {
			int parent = (index - 1) / 2;
			if (array[index] > array[parent]) {
				swap(array, index, parent);
				index = parent;
			} else {
				break;
			}
		}
	}

}