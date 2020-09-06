package com.example.seniordesignproject.Model;


import com.google.firebase.firestore.IgnoreExtraProperties;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

@IgnoreExtraProperties
public class Rate {

    public Rate(String neighborhood, String content, String rate_id, String user_id, int safety, int pricing, int sociability) {
        this.neighborhood = neighborhood;
        this.content = content;
        this.rate_id = rate_id;
        this.user_id = user_id;
        this.safety = safety;
        this.pricing = pricing;
        this.sociability = sociability;
    }

    public Rate(String neighborhood, String content, int safety, int pricing, int sociability) {
        this.neighborhood = neighborhood;
        this.content = content;
        this.safety = safety;
        this.pricing = pricing;
        this.sociability = sociability;
    }


    public Rate(String neighborhood, String content,String rate_id, String user_id) {
        this.neighborhood = neighborhood;
        this.content = content;
    }

    public Rate() {

    }



    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRate_id() {
        return rate_id;
    }

    public void setRate_id(String rate_id) {
        this.rate_id = rate_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getSafety() {
        return safety;
    }

    public void setSafety(int safety) {
        this.safety = safety;
    }

    public int getPricing() {
        return pricing;
    }

    public void setPricing(int pricing) {
        this.pricing = pricing;
    }

    public int getSociability() {
        return sociability;
    }

    public void setSociability(int sociability) {
        this.sociability = sociability;
    }

    private String neighborhood;
private String content;
private String rate_id;
private String user_id;
private int safety;
private int pricing;
private int sociability;



}
