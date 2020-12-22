package com.tlshzp.pojo;

import java.util.Date;
import java.util.Objects;

public class BBInfo {
    private long number;
    private int id;
    private Date borrow_date;
    private Date back_date;

    @Override
    public String toString() {
        return "BBInfo{" +
                "number=" + number +
                ", id=" + id +
                ", borrow_date=" + borrow_date +
                ", back_date=" + back_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BBInfo bbInfo = (BBInfo) o;
        return number == bbInfo.number && id == bbInfo.id && Objects.equals(borrow_date, bbInfo.borrow_date) && Objects.equals(back_date, bbInfo.back_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, id, borrow_date, back_date);
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getBack_date() {
        return back_date;
    }

    public void setBack_date(Date back_date) {
        this.back_date = back_date;
    }

    public BBInfo() {
    }

    public BBInfo(long number, int id, Date borrow_date, Date back_date) {
        this.number = number;
        this.id = id;
        this.borrow_date = borrow_date;
        this.back_date = back_date;
    }
}
