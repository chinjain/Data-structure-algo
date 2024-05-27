package linkedlist_problems;

import java.util.HashMap;
import java.util.Map;

public class LRU_Cache_Doubly_LinkedList {

	public static void main(String[] args) {

	}

}

class LruCache {
	private Map<Integer, ListNode> cache;
	private int capacity;

	private ListNode left;
	private ListNode right;

	public LruCache(int size) {
		this.capacity = size;
		cache = new HashMap<Integer, ListNode>();
		this.left = new ListNode(0, 0);
		this.right = new ListNode(0, 0);

		this.left.next = this.right;
		this.right.prev = this.left;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			remvove(cache.get(key));
			insert(cache.get(key));
			return cache.get(key).getValue();
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			remvove(cache.get(key));
		}

		cache.put(key, new ListNode(key, value));
		insert(cache.get(key));

		if (cache.size() >= capacity) {
			ListNode lru = this.left.next;
			remvove(lru);
			cache.remove(lru.getKey());
		}
	}

	private void insert(ListNode newNode) {
		ListNode prev = this.right.prev;
		ListNode next = this.right;

		prev.next = newNode;
		next.prev = newNode;

		newNode.prev = prev;
		newNode.next = newNode;

	}

	private void remvove(ListNode node) {

		ListNode prev = node.prev;
		ListNode next = node.next;

		prev.next = next;
		next.prev = prev;
		node.next = null;
		node.prev = null;

	}

}

class ListNode {
	private int key;
	private int value;

	ListNode next;
	ListNode prev;

	public ListNode(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
