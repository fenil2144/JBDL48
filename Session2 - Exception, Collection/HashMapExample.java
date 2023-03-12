import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapExample {
	
	public static void main(String[] args) {
		
		HashMap<Integer,String> phoneDirectory = new HashMap<Integer,String>();
		
		phoneDirectory.put(987878787, "Rajesh");
		phoneDirectory.put(67665656, "Mukesh");
		
		for(Entry<Integer,String> entry : phoneDirectory.entrySet()) {
			System.out.println(entry);
		}

	}

}
