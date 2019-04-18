package cn.yxj.elasticsearch;

import cn.yxj.elasticsearch.dao.UserReporistory;
import cn.yxj.elasticsearch.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.directory.DirContext;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchDemoApplicationTests {
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    UserReporistory userReporistory;
    @Autowired
    LdapTemplate ldapTemplate;
    @Test
    public void contextLoads() {
//        elasticsearchTemplate.createIndex()
//        List<User> users = elasticsearchTemplate.queryForList(new NativeSearchQuery(wildcardQuery("age","")), User.class);
//        List<User> users =  userReporistory.findByNameEndingWith("5");
//        System.out.println(users);
       try{
           String str = ",dc=domain,dc=com";
           String tempRoot = "cn=root";
           String root = tempRoot+ str;
           DirContext context = ldapTemplate.getContextSource().getContext(root, "sxd@123");
           System.out.println(context.getEnvironment());
           System.out.println("login success");
       }catch (Exception e){
           System.out.println("login error");
           System.out.println(e);
       }
    }

}
