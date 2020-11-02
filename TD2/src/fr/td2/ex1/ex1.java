package fr.td2.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ex1 {
	public static void main (String [] args) {
		Path path = Paths.get("names.txt");
		List<String> items = Arrays.asList();
		
		try (Stream<String> stream = Files.lines(path)) {
			//stream.forEach(System.out::println);
			
			/* stream.filter(Pattern
						.compile("a$").asPredicate()) */
			
			/*System.out.println(stream
						.distinct()
						.count());
						//.forEach(System.out::println);*/
			stream.map(n -> (n,1) .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())))
									.foreach(System.out::println);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
