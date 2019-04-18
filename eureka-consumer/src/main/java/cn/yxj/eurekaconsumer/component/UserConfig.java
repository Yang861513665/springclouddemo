package cn.yxj.eurekaconsumer.component;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

@ConfigurationProperties(prefix = "user")
public class UserConfig {
    private String name;
    private String pwd;

    @Override
    public String toString() {
        return "UserConfig{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    static {
        System.out.println("UserConfig 静态块调用..");
    }
    {
        System.out.println("构造块UserConfig调用...");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("调用 setName"+name);
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        System.out.println("调用setPwd"+pwd);
        this.pwd = pwd;
    }
    @PostConstruct
    void init(){
        System.out.println("postConstrutc 调用...");
    }
}
