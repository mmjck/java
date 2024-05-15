package br.com.mmjck.ioc_di;

import org.springframework.stereotype.Service;

@Service
public class MyComponent {
    public String call(){
        return "Component was called";
    }
}
