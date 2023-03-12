import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class CollectionExample {
	
	public static void main(String[] args) {
		
		
		List<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		
		System.out.println(integerList);
		
		integerList.remove(0);
		
		System.out.println(integerList);
		
		System.out.println(integerList.get(0));
		
		integerList.set(1, 5);

		System.out.println(integerList);
		
		Vector<Integer> integerVector = new Vector<>();
		
		Iterator<Integer> iteratorObj = integerList.iterator();
		
		while(iteratorObj.hasNext()) {
			System.out.println(iteratorObj.next());
		}
		
		for(Integer x: integerList) {
			System.out.println(x);
		}
	}

}
