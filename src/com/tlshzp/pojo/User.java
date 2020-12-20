package com.tlshzp.pojo;

import java.util.Objects;

public class User {
    private long number;    //mysql中BIGINT
    private String name;
    private boolean sex;    //true男，false女
    private long phone;
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", call=" + phone +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return number == user.number && sex == user.sex && phone == user.phone && Objects.equals(name, user.name) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, sex, phone, email);
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(long number, String name, boolean sex, long call, String email) {
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.phone = call;
        this.email = email;
    }
}
