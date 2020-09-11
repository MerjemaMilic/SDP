package com.example.seniordesignproject.Model;

public class Average {
    int safetyrate;
    int sociabilityrate;
    int pricingrate;
    float averagerate;
    float averagepricingrate;
    float averagesociabilityrate;
    String neighborhoodname;
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNeighborhoodname() {
        return neighborhoodname;
    }

    public void setNeighborhoodname(String neighborhoodname) {
        this.neighborhoodname = neighborhoodname;
    }

    public float getAveragepricingrate() {
        return averagepricingrate;
    }

    public void setAveragepricingrate(float averagepricingrate) {
        this.averagepricingrate = averagepricingrate;
    }

    public float getAveragesociabilityrate() {
        return averagesociabilityrate;
    }

    public void setAveragesociabilityrate(float averagesociabilityrate) {
        this.averagesociabilityrate = averagesociabilityrate;
    }

    float totalrate;
    long numberrating;
    long totalsumsafety;
    long totalsumsociability;
    long totalsumpricing;

    public long getTotalsumsociability() {
        return totalsumsociability;
    }

    public void setTotalsumsociability(long totalsumsociability) {
        this.totalsumsociability = totalsumsociability;
    }

    public long getTotalsumpricing() {
        return totalsumpricing;
    }

    public void setTotalsumpricing(long totalsumpricing) {
        this.totalsumpricing = totalsumpricing;
    }

    public long getTotalsumsafety() {
        return totalsumsafety;
    }

    public void setTotalsumsafety(long totalsumsafety) {
        this.totalsumsafety = totalsumsafety;
    }

    public long getNumberrating() {
        return numberrating;
    }

    public void setNumberrating(long numberrating) {
        this.numberrating = numberrating;
    }

    public Average(int safetyrate, int sociabilityrate, int pricingrate, float averagerate, float totalrate, long numberrating) {
        this.safetyrate = safetyrate;
        this.sociabilityrate = sociabilityrate;
        this.pricingrate = pricingrate;
        this.averagerate = averagerate;
        this.totalrate = totalrate;
        this.numberrating = numberrating;
    }

    public Average() {

    }

    public int getSafetyrate() {
        return safetyrate;
    }

    public void setSafetyrate(int safetyrate) {
        this.safetyrate = safetyrate;
    }

    public int getSociabilityrate() {
        return sociabilityrate;
    }

    public void setSociabilityrate(int sociabilityrate) {
        this.sociabilityrate = sociabilityrate;
    }

    public int getPricingrate() {
        return pricingrate;
    }

    public void setPricingrate(int pricingrate) {
        this.pricingrate = pricingrate;
    }

    public float getAveragerate() {
        return averagerate;
    }

    public void setAveragerate(float averagerate) {
        this.averagerate = averagerate;
    }

    public float getTotalrate() {
        return totalrate;
    }

    public void setTotalrate(float totalrate) {
        this.totalrate = totalrate;
    }
}
