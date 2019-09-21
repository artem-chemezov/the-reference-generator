package com.example.host;

public class Ref {

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Ref(){
        shortname = "null";
        fullname = "null";
    }

    public Ref(String shortname, String fullname) {
        this.shortname = shortname;
        this.fullname = fullname;
    }

    private String shortname;
    private String fullname;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String shortname) {
        this.fullname = fullname;
    }

    @Override
    public String toString(){
        return "fullname : " + this.fullname + "\nshortname : " + this.shortname;
    }

}
