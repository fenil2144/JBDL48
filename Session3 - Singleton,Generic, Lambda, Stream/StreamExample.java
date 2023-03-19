import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		
		//Without Lambda - using Annonymous Class
		System.out.println(numbers.stream().filter(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t%2 == 0;
			}
		}).map(new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer t) {
				return t*t;
			}
			
		}).collect(Collectors.toList()));
		
		
		//With Lambda
		System.out.println(numbers.stream().filter(t ->  {
			System.out.println("In filter Operation");
			return t%2==0;}).map(x -> {
				System.out.println("In Map operation");
				return x*x;}).collect(Collectors.toList())
				);
		
//		{4,16}
		
		List<String> names = Arrays.asList("Java","inheritance","Polymorphism","Abstraction");
		names.stream().filter(s -> s.startsWith("P")).collect(Collectors.toList());
		
		System.out.println(names.stream().sorted().collect(Collectors.toList()));
		System.out.println(numbers.stream().filter(x-> x%2 == 0).reduce(20, (ans,i) -> ans+i));
		
		names.stream()
		.filter(p -> p.startsWith("J") && p.length()>3)
		.map(p -> p.toUpperCase())
		.sorted()
		.forEach(p -> System.out.println(p));
	}

}
