package uk.co.terminological.rjava.test;

import java.util.Arrays;
import java.util.stream.DoubleStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.terminological.rjava.RClass;
import uk.co.terminological.rjava.RConverter;
import uk.co.terminological.rjava.RMethod;
import uk.co.terminological.rjava.UnconvertableTypeException;
import uk.co.terminological.rjava.types.RCharacter;
import uk.co.terminological.rjava.types.RCharacterVector;
import uk.co.terminological.rjava.types.RDataframe;
import uk.co.terminological.rjava.types.RFactor;
import uk.co.terminological.rjava.types.RFactorVector;
import uk.co.terminological.rjava.types.RInteger;
import uk.co.terminological.rjava.types.RIntegerVector;
import uk.co.terminological.rjava.types.RList;
import uk.co.terminological.rjava.types.RLogical;
import uk.co.terminological.rjava.types.RLogicalVector;
import uk.co.terminological.rjava.types.RNamedList;
import uk.co.terminological.rjava.types.RNumeric;
import uk.co.terminological.rjava.types.RNumericVector;
import uk.co.terminological.rjava.types.RPrimitive;
import uk.co.terminological.rjava.types.RVector;

@RClass
public class FactoryTest {

	Logger log = LoggerFactory.getLogger(FactoryTest.class);
	
	@RMethod
	public FactoryTest() {
		log.info("Tests the java creation of supported datatypes");
	}
	
	//SECTION_01
	
	@RMethod
	public RCharacter generateCharacter() {
		return RPrimitive.of("Hello world");
	}
	
	@RMethod
	public RNumeric generateNumeric() {
		return RPrimitive.of(123.0);
	}
	
	@RMethod
	public RInteger generateInteger() {
		return RPrimitive.of(345);
	}
	
	public static enum Test {
		ONE,TWO,THREE
	}
	
	@RMethod
	public RFactor generateFactor() {
		return RPrimitive.of(Test.ONE);
	}
	
	@RMethod
	public RLogical generateLogical() {
		return RPrimitive.of(true);
	}
	
	//SECTION_02
	
	@RMethod
	public RCharacterVector generateCharacterVec() {
		return RVector.with("Hello world","Ola el mundo","Bonjour le monde", null);
	}
	
	@RMethod
	public RNumericVector generateNumericVec() {
		return DoubleStream
				.of(3.0, 4.3, 2.1, 2.3).boxed()
				.collect(RConverter.doubleCollector());
	}
	
	@RMethod
	public RIntegerVector generateIntegerVec() {
		return RVector.with(345, 678, null, 89);
	}
	
	@RMethod
	public RFactorVector generateFactorVec() {
		return RVector.with(Test.ONE,Test.THREE,null,Test.TWO);
	}
	
	@RMethod
	public RLogicalVector generateLogicalVec() {
		return RVector.with(true,false,null);
	}
	
	//SECTION_03
	
	@RMethod
	public RDataframe generateDataframe() {
		return RDataframe.create()
			.withCol("A", RVector.with(3.0, 4.3, 2.1))
			.withCol("B", RVector.with(Test.ONE,Test.THREE,Test.TWO))
			.withCol("C", RVector.with("Hello world","Ola el mundo","Bonjour le monde"));
	}
	
	@RMethod
	public RDataframe generateStreamDataframe() {
		return 
			Arrays.asList("Hello","World","Stream","Support","in","Java")
			.stream()
			.collect(RConverter.dataframeCollector(
				RConverter.mapping("original", s-> s),
				RConverter.mapping("lowercase", s-> s.toLowerCase()),
				RConverter.mapping("uppercase", s-> s.toUpperCase()),
				RConverter.mapping("subst", s-> s.substring(0,Math.min(3,s.length()))),
				RConverter.mapping("length", s-> s.length())
			));
		
	}
	
	//SECTION_04
	
	/**
	 * Lists are much harder to type check than vectors hence RList builder methods throw checked exceptions 
	 * @return a RList containing the supplied Java objects converted into RObjects
	 * @throws UnconvertableTypeException if those objects are not themselves or cannot be converted into an RObject 
	 */
	@RMethod
	public RList generateList() throws UnconvertableTypeException {
		return RList.withRaw("one", Test.TWO, 3.0);
	}
	
	@RMethod
	public RNamedList generateNamedList() throws UnconvertableTypeException {
		return RNamedList
				.withRaw("A","one")
				.andRaw("B", Test.TWO)
				.andRaw("C", RVector.with(3.0, 4.3, 2.1));
	}
	
	//SECTION_05
}
