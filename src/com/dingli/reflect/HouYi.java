package com.dingli.reflect;

public class HouYi extends Heroes {
    private String blood;
    public String role;

    public HouYi(String name, int age, String blood, String role) {
        super(name, age);
        this.blood = blood;
        this.role = role;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public HouYi(String name, int age) {
        super(name, age);
    }
}
