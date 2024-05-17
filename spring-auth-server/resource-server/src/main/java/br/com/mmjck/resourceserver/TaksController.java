package br.com.mmjck.resourceserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("tasks")
public class TaksController {
    
    
    @GetMapping
    public String taks(
        @AuthenticationPrincipal Jwt jwt
    ) {
         return """
            <h1> Top secret taks for %s </h1
            <ol>
                <li> task 1 </li>
                <li> task 2 </li>
                <li> task 3 </li>
            </ol>

         """.formatted(jwt.getSubject());
    }
    
}
