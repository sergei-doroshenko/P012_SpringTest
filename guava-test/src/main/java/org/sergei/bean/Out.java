package org.sergei.bean;

/**
 * Created by Sergei_Doroshenko on 10/19/2016.
 */
public class Out {
    private String voice;
    private Long number;
    private Long expireDate;

    public Out() {
    }

    public Out(String voice, Long number, Long expireDate) {
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

    public Long getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Long expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Out{" +
                "voice='" + voice + '\'' +
                ", number=" + number +
                ", expireDate=" + expireDate +
                '}';
    }
}
