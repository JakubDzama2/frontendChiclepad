package rest.controllers;

import org.chiclepad.backend.business.session.Authenticator;
import org.chiclepad.backend.business.session.UserSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthenticationController {

    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    public void authenticate(@RequestBody Map<String, String> mapa) {
        UserSession userSession = Authenticator.INSTANCE.logIn(mapa.get("email"), mapa.get("password"));
        System.out.println(userSession.getUserId());
    }
}
