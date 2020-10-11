package com.dingli.uml;

/**
 *  用户信息
 */
public class User extends BasePojo{
    private Long id;  // 用户id
    private String username; // 用户名
    private String password; // 用户密码
    private String phone; // 用户电话
    private String email; // 用户邮件
    private Cart cart; // 用户购物车

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void getOrder(Order order) {

    }
}
