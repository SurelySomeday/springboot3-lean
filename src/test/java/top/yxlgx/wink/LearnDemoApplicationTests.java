package top.yxlgx.wink;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.query.NativeQuery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.yxlgx.wink.config.orm.jpa.JpaResultTransformer;
import top.yxlgx.wink.entity.Address;
import top.yxlgx.wink.entity.User;
import top.yxlgx.wink.mapper.UserMapper;
import top.yxlgx.wink.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class LearnDemoApplicationTests {

    @Resource
    UserRepository userRepository;
    @PersistenceContext
    EntityManager entityManager;
    @Resource
    UserMapper userMapper;

    @SuppressWarnings("unchecked")
    @Test
    void contextLoads() {
        List<User> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            User user=new User();
            user.setId((long) i);
            user.setName("张三"+i);
            user.setAge(10);
            //user.setAddressId(1L);
            Address address=new Address();
            address.setId(100+(long) i);
            address.setAddress("ss"+i);
            user.setAddress(address);
            list.add(user);
        }

        //userRepository.saveAll(list);
        Iterable<User> all = userRepository.findAll();
        System.out.println(all);
        Query nativeQuery = entityManager.createNativeQuery("select * from sys_user");
        List<User> resultList = nativeQuery.unwrap(NativeQuery.class)
                .setTupleTransformer(new JpaResultTransformer(User.class)).getResultList();
        System.out.println(resultList);
        List<User> userList = userMapper.getUserByLikeName("张三");
        System.out.println(userList);
    }

}
