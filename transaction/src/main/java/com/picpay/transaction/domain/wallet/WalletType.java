package com.picpay.transaction.domain.wallet;

public enum WalletType {
    COMUN(1),
    LOJISTA(2);
    // COMMON(1),
    // SHOPKEEPER(2)

    private int value;

    private WalletType(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
