package nl.novi.springboot.first_demo.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class greetController {

    @Value("${message.default.welcome}")
    private String welcomeMessage;

    @Value("${message.default.goodbye}")
    private String goodByeMessage;

    @GetMapping("/goodmorning")
    public String sayGoodmorning() {
        return welcomeMessage;
    }

    @GetMapping("/goodbye")
    public String sayGoodbye() {
        return goodByeMessage;
    }

}