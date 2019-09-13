package com.sanjaygoyaljpr.leetcode;

interface Stack<E> {

	void push(E t);

	E pop();

	E peek();

	boolean isEmpty();
}

class StackArray<E> implements Stack<E> {

	private int top = -1;
	
	private Object [] stack;
	
	public StackArray() {
		this(4);
	}
	
	public StackArray(int initialCapacity) {
		this.stack = new Object[initialCapacity];
	}

	@Override
	public void push(E e) {
		if(stack.length == top + 1) {
			System.out.println("Stack is Full");
			return;
		}
		
		stack[++top] = e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			return null;
		}
		return (E) stack[top--];
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			return null;
		}
		return (E) stack[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

}

public class StackArrayTest {
	
	public static void main(String[] args) {
		
		StackArray<Integer> stack = new StackArray<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		
		stack.pop();
		stack.pop();
		stack.pop();
	}
	

}
