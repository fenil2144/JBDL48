class ThreadA extends Thread{
	
	public void run() {
		System.out.println("ThreadA "+Thread.currentThread());
		for(int i=20;i>0;i--) {
			try {
				Thread.sleep(100);
				System.out.println("ThreadA Class with i= "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
class ThreadB extends Thread{
	public void run() {
		System.out.println("ThreadB "+Thread.currentThread());
		for(int i=20;i>0;i--) {
			try {
				Thread.sleep(100);
				System.out.println("ThreadB Class with i= "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class ThreadRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("ThreadRunnable "+Thread.currentThread());
		for(int i=20;i>0;i--) {
			try {
				Thread.sleep(100);
				System.out.println("ThreadRunnable Class with i= "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class ThreadBasicExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Main Method Thread "+Thread.currentThread());
		ThreadA threadA = new ThreadA();
		ThreadA threadA1 = new ThreadA();
		
		ThreadB threadB = new ThreadB();
		
		ThreadRunnable threadRunnable = new ThreadRunnable();
		Thread threadUsingRunnable = new Thread(threadRunnable);
		Thread threadUsingRunnable1 = new Thread(threadRunnable);


		
		threadA.setPriority(10);
		threadA.start();
		threadB.setDaemon(true);
		threadB.start();
		
		threadA.join();
		threadB.join();
		
		threadUsingRunnable.start();

		
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println("Total Memory Available to JVM "+Runtime.getRuntime().freeMemory());
		
		
	}

}
