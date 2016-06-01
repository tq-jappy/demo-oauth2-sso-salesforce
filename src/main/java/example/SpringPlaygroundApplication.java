package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class SpringPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPlaygroundApplication.class, args);
    }

    @RequestMapping("/hello")
    String hello() {
        return "Hello!";
    }

    @RequestMapping("/")
    String helloOAuth2(OAuth2Authentication authentication) {
        return "Hello " + authentication.getName();
    }

    @RequestMapping("/details")
    Object details(OAuth2Authentication authentication) {
        return authentication.getUserAuthentication();
    }
}
