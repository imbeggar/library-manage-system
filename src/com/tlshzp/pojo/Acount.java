package com.tlshzp.pojo;

import java.util.Objects;

public class Acount {
    private long number;
    private String password;
    private boolean identify;

    @Override
    public String toString() {
        return "Acount{" +
                "number=" + number +
                ", password='" + password + '\'' +
                ", identify=" + identify +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acount acount = (Acount) o;
        return number == acount.number && identify == acount.identify && Objects.equals(password, acount.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, password, identify);
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIdentify() {
        return identify;
    }

    public void setIdentify(boolean identify) {
        this.identify = identify;
    }

    public Acount(long number, String password) {
        this.number = number;
        this.password = password;
    }

    public Acount() {
    }

    public Acount(long number, String password, boolean identify) {
        this.number = number;
        this.password = password;
        this.identify = identify;
    }
}
