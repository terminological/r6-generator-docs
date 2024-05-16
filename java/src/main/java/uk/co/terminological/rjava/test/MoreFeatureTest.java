package uk.co.terminological.rjava.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.terminological.rjava.RClass;
import uk.co.terminological.rjava.RConverter;
import uk.co.terminological.rjava.RMethod;
import uk.co.terminological.rjava.types.RCharacter;

//START_SNIP_1
/**
 * This has no documentation
 */
@RClass
public class MoreFeatureTest {

	String message1;
	String message2;
	
	static Logger log = LoggerFactory.getLogger(MoreFeatureTest.class); 
	
	/**
	 * the first constructor is used if there are none annotated 
	 * @param message1 - the message to be printed 
	 * @param message2 - will be used for toString
	 */
	public MoreFeatureTest(RCharacter message1, RCharacter message2) {
		this.message1 = message1.toString();
		this.message2 = message2.toString();
		log.info("constuctor: {}, {}",this.message1, this.message2);
	}
	
	/** A static object constructor
	 * @param message1 - the message to be printed 
	 * @param message2 - will be used for toString
	 * @return A MoreFeatureTest R6 object
	 */
	@RMethod(examples = {
		"J = JavaApi$get()",
		"J$MoreFeatureTest$create('Hello,',' World')"
	})
	public static MoreFeatureTest create(RCharacter message1, RCharacter message2) {
		return new MoreFeatureTest(message1,message2);
	}
	
	public String toString() {
		return "toString: "+message2;
	}
	//END_SNIP_1
	//START_SNIP_2
	
	@RMethod 
	public void testLogging() {
		log.error("An error");
		log.warn("A warning");
		log.info("A info");
		log.debug("A debug");
		log.trace("A trace");
	}
			
	@RMethod
	public RCharacter throwCatchable() throws Exception {
		throw new Exception("A catchable exception has been thrown");
	}
	
	@RMethod
	public void printMessage() {
		System.out.println("Printed in java: "+message1+" "+message2);
	}
	
	@RMethod
	public RCharacter throwRuntime() {
		throw new RuntimeException("A runtime exception has been thrown");
	}
	
	
	//END_SNIP_2
	
	@RMethod
	public static RCharacter concat(RCharacter message1, RCharacter message2) {
		return RConverter.convert(message1.toString()+message2.toString());
	}
	
	@RMethod(
		tests = {
			"tmp = collider.more_feature_test('should ','work')",
			"expect_equal(tmp,'more feature test: should work')"
		}
	)
	public static RCharacter collider(RCharacter message1, RCharacter message2) {
		// This method name collides with another static method name.
		// the collision is resolved by adding the class name to the end of the 
		// static method name.
		return RConverter.convert("more feature test: "+message1.toString()+message2.toString());
	}
		
	//START_SNIP_1
}
//END_SNIP_1
