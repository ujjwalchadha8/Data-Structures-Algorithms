package heaps;

public interface MinHeap<T extends Comparable<T>> {
	T findMin();
	T extractMin();
	void insert(T element);
	void build(T[] elements);
}
