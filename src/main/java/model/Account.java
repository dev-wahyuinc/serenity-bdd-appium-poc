package model;

import io.cucumber.java.en_old.Ac;

public enum Account {
    REGISTERED("sap@rol.com"),
    UNREGISTER("sapr@ol.com"),
    INVALIDEMAIL("aaddf@gmail.com");

    private String emailAccount;

    Account(String email) {
        this.emailAccount = email;
    }
    public String getAccount(){
        return this.emailAccount;
    }

    public void setValidAccount(String email){
        this.emailAccount = email;
    }
}
