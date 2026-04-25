package in.ram.in28minutes.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private MessageSource messageSource;

	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping("/hello-world")
	public HelloWorld helloWorld() {
		return new HelloWorld("Hello World");
	}

	@GetMapping("/hello-world/{user}")
	public HelloWorld helloWorldUser(@PathVariable String user) {
		return new HelloWorld(String.format("Hello World %s", user));
	}

	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized() {

		Locale locale = LocaleContextHolder.getLocale();
		System.out.println(locale);
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);

		// 1. good.morning.message
		// 2. en - English (Good Morning)
		// nl - Dutch (Goedemorgen)
		// fr - French (Bonjour)
		// de - Deutsch (Guten Morgen)
//		return new HelloWorld("Hello World V2");
	}

}
