package com.sam.jsonApp;

public class MongoDbPojo {

    Float Avg_Visits_Duration;
    Float Frequency;
    String Visitors;
    String cluster;
    String Customer;

    public Float getAvg_Visits_Duration() {
        return Avg_Visits_Duration;
    }

    public void setAvg_Visits_Duration(Float avg_Visits_Duration) {
        Avg_Visits_Duration = avg_Visits_Duration;
    }

    public Float getFrequency() {
        return Frequency;
    }

    public void setFrequency(Float frequency) {
        Frequency = frequency;
    }

    public String getVisitors() {
        return Visitors;
    }

    public void setVisitors(String visitors) {
        Visitors = visitors;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }
}
