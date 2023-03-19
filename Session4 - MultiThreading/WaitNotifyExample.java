class Demo{
	boolean verifyMethod1 = false;
	
	synchronized void method1() {
		System.out.println("In Method1 "+Thread.currentThread().getName());
		
		if(Thread.currentThread().getName().equalsIgnoreCase("Thread-0")) {
			try {
				System.out.println("Executing "+Thread.currentThread().getName());
				wait();
				System.out.println("Executing Thread-0 after wait"+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(Thread.currentThread().getName().equalsIgnoreCase("Thread-1")) {
			System.out.println("Executing "+Thread.currentThread().getName());
			try {
				wait();
				System.out.println("Executing Thread-1 after wait"+Thread.currentThread().getName());

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			notify();
		}
//		verifyMethod1=true;
//		System.out.println("Thread t1 about to surrender lock");
//		notify();
	}
	
	synchronized void method2() {
		
		while(!verifyMethod1) {
			try {
				System.out.println("Thread t2 waiting "+Thread.currentThread().getName());
				wait();
				System.out.println("Thread t2 running after wait");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Outside While");
	}
}


public class WaitNotifyExample {
	
	public static void main(String[] args) {
		
		//We are acquiring Lock on Object d
		Demo d = new Demo();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				d.method1();

			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				d.method1();

			}
		});
		
		t2.start();
		t1.start();
	}

}
