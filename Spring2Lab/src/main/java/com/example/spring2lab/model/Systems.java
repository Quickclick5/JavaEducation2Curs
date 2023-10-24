package com.example.spring2lab.model;

public enum Systems {
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System");

    public final String name;

    Systems(String name) {
        this.name = name;
    }
}