package cn.yxj.eurekaapi.entity;


public class User {

    private String username;
    private String password;
    private int age;
    private String authorities;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", authorities='" + authorities + '\'' +
                '}';
    }

    public User(){

    }
    public User(String username, String password, int age){
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
