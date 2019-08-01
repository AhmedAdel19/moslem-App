package com.example.azkarelmoslem.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Azkar_Content
{
    @SerializedName("zekr")
    @Expose
    private String zekr;
    @SerializedName("repeat")
    @Expose
    private Integer repeat;
    @SerializedName("bless")
    @Expose
    private String bless;



    public String getZekr() {
        return zekr;
    }

    public void setZekr(String zekr) {
        this.zekr = zekr;
    }

    public Integer getRepeat() {
        return repeat;
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }

    public String getBless() {
        return bless;
    }

    public void setBless(String bless) {
        this.bless = bless;
    }


}
