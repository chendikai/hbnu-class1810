package com.dingli.Heroes;

public class Test {
    public static void main(String[] args) {
        Heroes heroes2 = new HouYi();
        Heroes heroes3 = new DaJi();

        heroes2.run(); // 后羿移动......
        System.out.println("后羿的角色id：" + heroes2.roleId); // 2

        heroes3.run(); // 妲己移动......
        System.out.println("妲己的角色id：" + heroes3.roleId); // 3
    }
}
