package com.project.localez;

import java.util.ArrayList;

public class Article {
    private String status;
    private String totaldata;
    private ArrayList<Model> articles;

    public Article(String status, String totaldata, ArrayList<Model> articles) {
        this.status = status;
        this.totaldata = totaldata;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotaldata() {
        return totaldata;
    }

    public void setTotaldata(String totaldata) {
        this.totaldata = totaldata;
    }

    public ArrayList<Model> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Model> articles) {
        this.articles = articles;
    }
}
