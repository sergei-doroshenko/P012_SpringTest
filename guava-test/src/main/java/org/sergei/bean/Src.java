package org.sergei.bean;

import java.util.Date;

/**
 * Created by Sergei_Doroshenko on 10/19/2016.
 */
public class Src {
    private String voice;
    private Long number;
    private Date expireDate;

    public Src() {
    }

    public Src(String voice, Long number, Date expireDate) {
        this.voice = voice;
        this.number = number;
        this.expireDate = expireDate;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Src{" +
                "voice='" + voice + '\'' +
                ", number=" + number +
                ", expireDate=" + expireDate +
                '}';
    }
}
