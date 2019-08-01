package com.example.azkarelmoslem.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Zekr
{
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("content")
    @Expose
    private List<Azkar_Content> content = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Azkar_Content> getContent() {
        return content;
    }

    public void setContent(List<Azkar_Content> content) {
        this.content = content;
    }
}
