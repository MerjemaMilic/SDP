package com.example.seniordesignproject.Model;

public class Feedback {
    String opinion;
    String opinionid;

    public Feedback(String opinion, String opinionid) {
        this.opinion = opinion;
        this.opinionid = opinionid;
    }
public Feedback() {

}
    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getOpinionid() {
        return opinionid;
    }

    public void setOpinionid(String opinionid) {
        this.opinionid = opinionid;
    }
}
