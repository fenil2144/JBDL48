import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
	
	private String name;
	
	public Task(String s) {
		this.name = s;
	}

	@Override
	public void run() {

		try {
			Date d = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
			System.out.println("Executing for "+name+"= " +ft.format(d) +" "+Thread.currentThread());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
public class ThreadPoolExample {
	
	public static void main(String[] args) {
		
		Runnable r1 = new Task("task1");
		Runnable r2 = new Task("task2");
		Runnable r3 = new Task("task3");
		Runnable r4 = new Task("task4");
		Runnable r5 = new Task("task5");
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);

	}
	



}
