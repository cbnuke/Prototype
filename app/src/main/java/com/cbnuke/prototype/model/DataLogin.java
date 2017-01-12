package com.cbnuke.prototype.model;

/**
 * Created by Amnart on 12/1/2560.
 */

public class DataLogin {
    String HW;
    String PW;
    String Token;

    public DataLogin(String HW, String PW, String token) {
        this.HW = HW;
        this.PW = PW;
        Token = token;
    }

    public String getHW() {
        return HW;
    }

    public void setHW(String HW) {
        this.HW = HW;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
