package com.bdia;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/bdia", snippets = CucumberOptions.SnippetType.CAMELCASE, dryRun = false)
public class RunnerTest {
}
