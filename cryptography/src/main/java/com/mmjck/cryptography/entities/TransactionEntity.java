package com.mmjck.cryptography.entities;

import com.mmjck.cryptography.service.CryptoService;
import com.mmjck.cryptography.service.serviceImpl.CryptoServiceImpl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_document")
    @NotBlank(message = "add user_document field")
    private String encryptedUserDocument;

    @Column(name = "credit_card_token")
    @NotBlank(message = "add credit_card_token field")
    private String encryptedCreditCardToken;

    @Column(name = "transaction_value")
    private Long transactionValue;

    @Transient
    private String rawCreditCardToken;

    @Transient
    private String rawUserDocument;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEncryptedUserDocument() {
        return encryptedUserDocument;
    }

    public void setEncryptedUserDocument(String encryptedUserDocument) {
        this.encryptedUserDocument = encryptedUserDocument;
    }

    public String getEncryptedCreditCardToken() {
        return encryptedCreditCardToken;
    }

    public void setEncryptedCreditCardToken(String encryptedCreditCardToken) {
        this.encryptedCreditCardToken = encryptedCreditCardToken;
    }

    public Long getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(Long transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getRawCreditCardToken() {
        return rawCreditCardToken;
    }

    public void setRawCreditCardToken(String rawCreditCardToken) {
        this.rawCreditCardToken = rawCreditCardToken;
    }

    public String getRawUserDocument() {
        return rawUserDocument;
    }

    public void setRawUserDocument(String rawUserDocument) {
        this.rawUserDocument = rawUserDocument;
    }


    @PrePersist
    public void prePersist(){
        CryptoService encryption = new CryptoServiceImpl();
        this.encryptedCreditCardToken = encryption.encrypt(rawCreditCardToken);
        this.encryptedUserDocument = encryption.encrypt(rawUserDocument);
    }

    @PostLoad
    public void postLoad(){
        CryptoService encryption = new CryptoServiceImpl();

        this.rawCreditCardToken = encryption.descrypt(encryptedCreditCardToken);
        this.rawUserDocument = encryption.descrypt(encryptedUserDocument);
    }
}
