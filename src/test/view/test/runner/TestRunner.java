package view.test.runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.sikuli.basics.Settings;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"html:target/cucumber"},
		features = {"src/test/resources"},
		glue="view.test.glue",
		tags= {"@CriptografiaSha1"})

public class TestRunner {
	
	@BeforeClass
	public static void setUp() throws Exception {
		Settings.BundlePath = "pictures"; 
		Settings.MinSimilarity = 0.90;
		Settings.Highlight = false; 
		Settings.DefaultHighlightTime = (float) 1.0; 
		Settings.LogTime = true; 
	}

}