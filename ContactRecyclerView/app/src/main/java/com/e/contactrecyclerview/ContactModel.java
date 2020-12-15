package com.e.contactrecyclerview;

public class ContactModel {
    private String contact;
    private boolean isHeader;

    public ContactModel(String contact, boolean isHeader){
        this.contact = contact;
        this.isHeader = isHeader;
    }
    public String getContact(){
        return contact;
    }
    public boolean isHeader(){
        return isHeader;
    }
}
