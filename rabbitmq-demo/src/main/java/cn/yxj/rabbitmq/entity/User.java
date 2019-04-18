package cn.yxj.rabbitmq.entity;

/**
 * @author yangxj
 * @date 2019-3-7 9:38
 */
public class User {
    private Integer id;
    private String name;
    private String address;
    private int age;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
