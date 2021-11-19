package com.sours.and.ayat;

public class SuraObject {

    String name;
    int number;

    String type;


    public SuraObject(String name, int number, String type) {

        this.name = name;
        this.number = number;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
