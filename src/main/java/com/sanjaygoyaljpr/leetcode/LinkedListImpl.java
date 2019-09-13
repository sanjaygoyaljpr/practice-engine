package com.sanjaygoyaljpr.leetcode;

import java.util.Stack;

class Node<E> {
	E data;
	Node<E> next;

	public Node(E e) {
		this.data = e;
		this.next = null;
	}
}

interface LinkedList<E> {
	void add(E e);

	void remove(E e);

	void printList();
}

public class LinkedListImpl<E> implements LinkedList<E> {

	private Node<E> head;

	int size;

	public LinkedListImpl() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public void add(E e) {

		Node<E> newNode = new Node<>(e);

		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	@Override
	public void remove(E e) {
		if (head == null) {
			System.out.println("LinkedList is Empty!!");
		}

		if (head != null && head.data.equals(e)) {
			head = head.next;
			size--;
			return;
		}

		Node<E> current = head;
		Node<E> previous = null;
		;

		while (current != null && !current.data.equals(e)) {
			previous = current;
			current = current.next;
		}

		if (current == null) {
			System.out.println("Key not found");
			return;
		}

		previous.next = current.next;
		size--;

	}

	@Override
	public void printList() {
		System.out.println("Total Nodes in LinkedList: " + size);

		Node<E> current = head;

		while (current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}

	}

	public void reverseListWithStack() {
		System.out.println("Reverse List: ");

		java.util.LinkedList<Integer> stack = new java.util.LinkedList<>();

		Node<E> current = head;

		while (current != null) {
			stack.push((Integer) current.data);
			current = current.next;
		}

		while (stack.size() > 0) {
			System.out.print(stack.pop() + " --> ");
		}

	}

	public void reverseListWithPointers() {
		System.out.println("Reverse List: ");

		Node<E> current = head;
		Node<E> previous = null;
		Node<E> currentNext = null;

		while (current != null) {
			currentNext = current.next;
			current.next = previous;
			previous = current;
			current = currentNext;
		}

		head = previous;

		printList();

	}

	public void getMiddleNode() {
		Node<E> slow = head;
		Node<E> fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		System.out.println("Middle Node: " + slow.data);
	}

	public void getKthNodeFromLast(int k) {

		if (head == null) {
			System.out.println("List is Empty!!");
			return;
		}

		Node<E> kThPointer = head;
		Node<E> aheadPointer = head;

		int i = k;

		while (i-- > 0) {
			if (aheadPointer != null) {
				aheadPointer = aheadPointer.next;
			} else {
				System.out.println("Length of list less than: " + k);
				return;
			}
		}

		while (aheadPointer != null) {
			kThPointer = kThPointer.next;
			aheadPointer = aheadPointer.next;
		}

		System.out.println("kTh Node: " + kThPointer.data);
	}

	public static void main(String[] args) {

		LinkedListImpl<Integer> linkedList = new LinkedListImpl<>();

		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);
		linkedList.add(50);
		linkedList.add(60);
		linkedList.add(70);

		linkedList.printList();

		linkedList.getKthNodeFromLast(6);

	}

}
