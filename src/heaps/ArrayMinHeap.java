package heaps;

import java.util.ArrayList;

public class ArrayMinHeap<T extends Comparable<T>> implements MinHeap<T> {
	
	private static final int LEFT = 0, RIGHT = 1;

	private ArrayList<T> heap;
	
	public ArrayMinHeap(ArrayList<T> heap) {
		this.heap = heap;
	}
	
	@Override
	public T findMin() {
		if(heap.isEmpty()) return null;
		return heap.get(0);
	}

	@Override
	public T extractMin() {
		if(heap.isEmpty()) return null;
		T element = heap.get(0);;
		if(heap.size() == 1) {
			heap.clear();
		}else {
			heap.set(0, valueAt(heap.size()-1));
			heap.remove(heap.size() - 1);
			minHeapify(0);
		}
		return element;
	}

	@Override
	public void insert(T element) {
		heap.add(element);
		decreaseKey(heap.size() - 1);
	}

	@Override
	public void build(T[] elements) {
		for(int i = heap.size()/2; i >= 0; i--) {
			minHeapify(i);
		}
	}
	
	@Override
	public String toString() {
		String heapString = "";
		int elementIndex = 0;
		for(int level = 0; ; level++) {
			for(int i = 0; i < Math.pow(2, level); i++) {
				if(valueAt(elementIndex) == null) return heapString;
				heapString += valueAt(elementIndex) + " ";
				elementIndex++;
			}
			heapString += "\n";
		}
	}

	private void minHeapify(int index) {
		if(valueAt(getLeftChild(index)) != null && valueAt(getLeftChild(index)).compareTo(valueAt(index)) < 0) {
			swapValues(getLeftChild(index), index);
			minHeapify(getLeftChild(index));
		} else if(valueAt(getRightChild(index)) != null && valueAt(getRightChild(index)).compareTo(valueAt(index)) < 0) {
			swapValues(getRightChild(index), index);
			minHeapify(getRightChild(index));
		}
	}
	
	private void decreaseKey(int index) {
		if(valueAt(getParent(index)) != null && valueAt(index).compareTo(valueAt(getParent(index))) < 0) {
			swapValues(index, getParent(index));
			decreaseKey(getParent(index));
		}
	}
	
	private T valueAt(int index) {
		try {
			return heap.get(index);
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	private void set(int index, T value) {
		heap.set(index, value);
	}
	
	private int getParent(int i) {
		if(i == 0) return -1;
		return (i-1) / 2;
	}
	
	private int[] getChildren(int i) {
		return new int[] {(2*i) + 1, (2*i) + 2 };
	}
	
	private int getLeftChild(int i) {
		return getChildren(i)[LEFT];
	}
	
	private int getRightChild(int i) {
		return getChildren(i)[RIGHT];
	}
	
	private void swapValues(int i1, int i2) {
		T temp = valueAt(i1);
		set(i1, valueAt(i2));
		set(i2, temp);
	}
	
	private static void test(int n) {
		if(n == 0) {
			System.out.println(0);
			return;
		}
		System.out.println(n);
		test((int)Math.ceil(n/2));
		test((int)Math.floor(n/2));
		System.out.println(1);
	}
	
	public static void main(String[] args) {
//		ArrayMinHeap<Integer> minHeap = new ArrayMinHeap<>(new ArrayList<>() {{
//			add(1);
//			add(2);
//			add(3);
//			add(4);
//			add(50);
//			add(6);
//			add(7);
//			add(8);
//			add(90);
//			add(10);
//			add(11);
//			add(120);
//			add(13);
//			add(14);
//			add(150);
//			add(16);
//			add(17);
//			add(180);
//			add(19);
//		}});
//		minHeap.decreaseKey(17);
		//minHeap.extractMin();
		//minHeap.insert(2);
		
//		System.out.println(Math.ceil(3/2));
		
		
	}

}
