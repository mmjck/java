package com.picpay.transaction.domain.authorization;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.picpay.transaction.domain.transaction.Transaction;

@Service
public class AuthorizerService {
    private RestClient restClient;

    public AuthorizerService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("SERVICE_URL_AUTHORIZER")
                .build();
    }

    public void authorize(Transaction transaction) {

        var response = restClient
                .get()
                .retrieve()
                .toEntity(Authorization.class);

        if (response.getStatusCode().isError() || !response.getBody().isAuthorized()) {
            throw new UnauthorizedTransactionException("Unauthorized transaction!");
        }

    }
}
