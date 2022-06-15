package uk.co.terminological.rjava.test;
//START
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.terminological.rjava.RClass;
import uk.co.terminological.rjava.RMethod;
import uk.co.terminological.rjava.types.RDataframe;

/**
 * This class is a very basic example of the features of the rJava maven plugin. <br>
 * The class is annotated with an @RClass to identify it as part of the R API. <br>
 */
@RClass
public class MinimalExample {

	static Logger log = LoggerFactory.getLogger(MinimalExample.class);
	
	@RMethod(examples = {
		"minExample = J$MinimalExample$new()",
		"minExample$demo(dataframe=tibble::tibble(input=c(1,2,3)), message='Hello world')"
	})
	/**
	 * Documentation of the method can be done in JavaDoc and these will be present in the R documentation 
	 * @param dataframe - a dataframe with an arbitrary number of columns
	 * @param message - a message
	 * @return the dataframe unchanged
	 *  
	 */
	public RDataframe demo(RDataframe dataframe, String message) {
		log.info("this dataframe has nrow="+dataframe.nrow());
		log.info(message);
		return dataframe;
	}
	
}
//END
