package com.tlshzp.pojo;

import java.util.Objects;

public class Count {
    private int cnt;
    private int tmp;

    @Override
    public String toString() {
        return "Count{" +
                "cnt=" + cnt +
                ", tmp=" + tmp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count = (Count) o;
        return cnt == count.cnt && tmp == count.tmp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnt, tmp);
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getTmp() {
        return tmp;
    }

    public void setTmp(int tmp) {
        this.tmp = tmp;
    }

    public Count(int cnt, int tmp) {
        this.cnt = cnt;
        this.tmp = tmp;
    }

    public Count() {
    }
}
