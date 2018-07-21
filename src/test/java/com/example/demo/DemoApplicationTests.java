package com.example.demo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.driver.v1.exceptions.ServiceUnavailableException;
import org.neo4j.ogm.session.Neo4jSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void testDefaultSettings() {
		try {
			DemoApplication.main(new String[0]);
		}
		catch (Exception ex) {
			if (!neo4jServerRunning(ex)) {
				return;
			}
		}
		String output = this.outputCapture.toString();
		assertThat(output).contains("firstName='Alice', lastName='Smith'");
	}

	private boolean neo4jServerRunning(Throwable ex) {
		if (ex instanceof ServiceUnavailableException) {
			return false;
		}
		return (ex.getCause() == null || neo4jServerRunning(ex.getCause()));
	}

}
