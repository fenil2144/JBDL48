import java.util.Arrays;
import java.util.List;

public class ParrallelStreamExample {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("J","A","V","B","C","K","E","N","D");
		
		list.stream().forEach(System.out:: print);
		System.out.println();
		list.parallelStream().forEach(System.out:: print);
		
		//JAVBCKEND
		//KCJEANVBD
		//KCJEBANVD
	}

}
