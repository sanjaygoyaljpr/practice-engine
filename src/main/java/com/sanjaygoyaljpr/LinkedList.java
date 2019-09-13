package com.sanjaygoyaljpr;

public class LinkedList {
	
	class Node {
		int data;
		Node next;
		
		public Node() {
			this.data = 0;
			this.next = null;
		}
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	Node head;
	
	public LinkedList() {
		this.head = null;
	}
	
	public void addNode(int value) {
		if(head == null) {
			Node newNode = new Node(value);
			this.head = newNode;
		} else {
			Node current = head;
			
			while(current.next != null) {
				current = current.next;
			}
			
			Node newNode = new Node(value);
			current.next = newNode;
			
		}
		
	}
	
	public void addAtFirst(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
	}
	
	public void printList() {
		Node current = head;
		
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public void reverse() {
		Node current = head;
		
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList();
		linkedList.addNode(10);
		linkedList.addNode(20);
		linkedList.addNode(30);
		linkedList.addNode(40);
		
		linkedList.printList();
		System.out.println("---------------");
		
		linkedList.addAtFirst(50);
		linkedList.addAtFirst(60);
		
		linkedList.printList();

	}
	
	
	

}
