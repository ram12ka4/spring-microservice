package in.ram.in28minutes.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public HelloWorld helloWorld() {
        return new HelloWorld("Hello World");
    }

    @GetMapping("/hello-world/{user}")
    public HelloWorld helloWorldUser(@PathVariable String user) {
        return new HelloWorld(String.format("Hello World %s", user));
    }

}
