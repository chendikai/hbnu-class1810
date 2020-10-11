package com.dingli.array;

public class Heroes {
    private String name;
    private String role;
    static int roleId;
    static final double PI = 3.1415926;

    public Heroes(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public static int getRoleId() {
        return roleId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static void setRoleId(int roleId) {
        Heroes.roleId = roleId;
    }

    public Heroes() {
        this("后羿","射手");

    }

    public void run(double speed) {
        String name = "铠";
        int id = 0;
        System.out.println("移动" + speed + ":" + this.name);
    }

    public static void bloodReturning(String home) {
        System.out.println("回血：" + home);
    }
}
