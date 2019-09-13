package com.sanjaygoyaljpr.concurrent;

class TaskEvenOdd implements Runnable {

	int max;
	boolean isOdd;
	Printer printer;

	public TaskEvenOdd(int max, Printer printer, boolean isOdd) {
		this.max = max;
		this.printer = printer;
		this.isOdd = isOdd;
	}

	@Override
	public void run() {

		int number = isOdd ? 1 : 2;

		while (number <= max) {
			if (isOdd) {
				printer.printOdd(number);
			} else {
				printer.printEven(number);
			}
			number = number + 2;
		}
	}

}

class Printer {

	private volatile boolean isPrintOdd = true;

	public synchronized void printOdd(int number) {
		while (!isPrintOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(Thread.currentThread().getName() + ":  " + number);
		isPrintOdd = false;
		notify();
	}

	public synchronized void printEven(int number) {
		while (isPrintOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(Thread.currentThread().getName() + ": " + number);
		isPrintOdd = true;
		notify();
	}
}

public class ThreadOddEvenTest {

	public static void main(String[] args) {
		System.out.println("Starting Thread: " + Thread.currentThread().getName());

		Printer printer = new Printer();

		Thread oddThread = new Thread(new TaskEvenOdd(10, printer, true), "Odd Thread");

		Thread evenThread = new Thread(new TaskEvenOdd(10, printer, false), "Even Thread");

		oddThread.start();
		evenThread.start();

		try {
			oddThread.join();
			evenThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Exiting Thread: " + Thread.currentThread().getName());
	}

}
