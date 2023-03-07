package top.yxlgx.wink;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.query.NativeQuery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import top.yxlgx.wink.config.orm.jpa.JpaResultTransformer;
import top.yxlgx.wink.entity.User;
import top.yxlgx.wink.mapper.UserMapper;
import top.yxlgx.wink.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class LearnDemoApplicationTests {


    @SuppressWarnings("unchecked")
    @Test
    void contextLoads() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
        encode = bCryptPasswordEncoder.encode("admin");
        System.out.println(encode);
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
        encode = bCryptPasswordEncoder.encode("admin");
        System.out.println(encode);
    }

}
