package pl.arturczopek.mycoach.web.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author Artur Czopek
 * @Date 10/16/16
 */

@Controller
@Profile("dev")
public class SwaggerController {

    private static final String SWAGGER_URL = "redirect:/swagger-ui.html";

    @RequestMapping(value = "${my-coach.swagger.path}", method = RequestMethod.GET)
    public String swaggerMapping() {
        return SWAGGER_URL;
    }
}
