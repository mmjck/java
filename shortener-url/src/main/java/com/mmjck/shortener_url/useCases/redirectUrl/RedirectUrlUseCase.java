package com.mmjck.shortener_url.useCases.redirectUrl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mmjck.shortener_url.controllers.repositories.UrlRepository;

@Service
public class RedirectUrlUseCase {
    @Autowired 
    private UrlRepository repository;

    public void execute(String id){
        //     Optional<UrlEntity> url = repository.findById(id);


        // if(url.isEmpty()){
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
        // }

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setLocation(URI.create(url.get().getFullUrl()));
    }
}
