package arun.snyk.scan.route;

import java.util.concurrent.atomic.AtomicLong;

import arun.snyk.scan.model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private Logger log = LoggerFactory.getLogger(GreetingController.class);

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		log.info("User input data "+name);
		int i = 0;
		int j = 34;
		float n = j/i;
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}