package uk.co.terminological.rjava.test;

//START
import uk.co.terminological.rjava.RName;
import uk.co.terminological.rjava.types.RFactor;
import uk.co.terminological.rjava.types.RInteger;
import uk.co.terminological.rjava.types.RNumeric;

public interface DiamondPOJO {

	@RName("carat") public RNumeric getCarat();
	@RName("depth") public RNumeric getDepth();
	@RName("table") public RNumeric getTable();
	@RName("price") public RInteger getPrice();
	@RName("clarity") public RFactor getClarity();
	
}
//END
