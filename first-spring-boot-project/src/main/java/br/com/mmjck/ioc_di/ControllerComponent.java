package br.com.mmjck.ioc_di;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/component")
public class ControllerComponent {
    @Autowired
    MyComponent component;

    @GetMapping("/")
    public String callComponent() {
        var result = component.call();
        return result;
    }
}
