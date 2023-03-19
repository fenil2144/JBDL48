class Sender{
	public synchronized void send(String msg) {

		try {
			Thread.sleep(400);
			System.out.println("\n"+msg+" sent");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ThreadSend extends Thread{
	private String msg;
	Sender sender;
	
	public ThreadSend(String msg, Sender sender) {
		super();
		this.msg = msg;
		this.sender = sender;
	}
	
	public void run() {
		sender.send(msg);
	}
}

public class SynchronizedDemo {
	
	public static void main(String[] args) {
	
		Sender send = new Sender();
		ThreadSend s1 = new ThreadSend("HI ", send);
		ThreadSend s2 = new ThreadSend("Bye ", send);
		
		s1.start();
		s2.start();

	}

}
