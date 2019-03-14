package org.sonar.samples.java.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class AvoidTooManyParametersForMethodTest {
	  @Test
	  public void verify() {
	    // In order to test this check efficiently, we added the test-jar "org.apache.commons.commons-collections4" to the pom,
	    // which is normally not used by the code of our custom plugin.
	    // All the classes from this jar will then be read when verifying the ticket, allowing correct type resolution.

	    // Verifies automatically that the check will raise the adequate issues with the expected message
	    //new comment to test git
		  JavaCheckVerifier.verify("src/test/files/AvoidTooManyParametersForMethodCheck.java", new AvoidTooManyParametersForMethodRule());
	    }
	  
}
