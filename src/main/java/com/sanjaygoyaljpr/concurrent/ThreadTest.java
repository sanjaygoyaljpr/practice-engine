package com.sanjaygoyaljpr.concurrent;

enum EasySingleton{
    INSTANCE;
}

public class ThreadTest {
	
	private ThreadTest threadTest;
	
	private ThreadTest() {
		if(threadTest != null) {
			
		}
	}

	public static void main(String[] args) {
		
		Object ob = new Object();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				//System.out.println("Running Thread T1");
				try {
					Thread.sleep(10*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Exit Thread T1");
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				//System.out.println("Running Thread T2");
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Exit Thread T2");
			}
		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				//System.out.println("Running Thread T3");
				try {
					t2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Exit Thread T3");
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		/*
		 * try { t1.join(); t2.join(); t3.join(); } catch (InterruptedException
		 * e) { e.printStackTrace(); }
		 */
		
		System.out.println("Exit Main Thread");

	}

}
