package uk.co.terminological.rjava.test;

import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import uk.co.terminological.rjava.UnconvertableTypeException;

public class JavaConversionTest {

	@Test
	public void test() throws IOException {
		
		// System.out.println(FeatureTest.diamonds());
		
		try {
		
			
			//BOUND_START
			Stream<DiamondPOJO> bound = FeatureTest
				.diamonds()
				.attach(DiamondPOJO.class)
				.streamCoerce();
			
			double averageDepth = bound.mapToDouble(d -> d.getDepth().get()).average().getAsDouble();
			System.out.print("average depth: "+averageDepth);
			
			// mean(diamonds$depth)
			// [1] 61.7494
			//BOUND_END
		
		} catch (UnconvertableTypeException e) {
			e.printStackTrace();
		}
	}

}
