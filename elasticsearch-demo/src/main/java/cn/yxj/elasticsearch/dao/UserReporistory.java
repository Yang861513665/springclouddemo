package cn.yxj.elasticsearch.dao;

import cn.yxj.elasticsearch.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author yangxj
 * @date 2019-3-7 13:56
 */
public interface UserReporistory extends ElasticsearchRepository<User,Integer> {
    List<User> findByNameAndAge(String name, int age);
    List<User> findByNameOrAge(String name, int age);
    List<User> findByAgeBetweenOrderByAgeDesc(int age, int end);
    List<User> findByNameEndingWith(String nameSuffix);
}
