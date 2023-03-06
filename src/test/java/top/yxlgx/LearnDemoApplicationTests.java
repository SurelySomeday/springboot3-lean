package top.yxlgx;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.sql.internal.NativeQueryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.yxlgx.config.MyResultTransformer;
import top.yxlgx.entity.Address;
import top.yxlgx.entity.User;
import top.yxlgx.repository.UserRepository;

import java.util.List;

@SpringBootTest
class LearnDemoApplicationTests {

    @Resource
    UserRepository userRepository;
    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Test
    void contextLoads() {
        User user=new User();
        user.setId(1L);
        user.setName("张三");
        user.setAge(10);
        //user.setAddressId(1L);
        Address address=new Address();
        address.setId(1L);
        address.setAddress("ss");
        user.setAddress(address);
        userRepository.save(user);
        Iterable<User> all = userRepository.findAll();
        System.out.println(all);
        Query nativeQuery = entityManager.createNativeQuery("select * from sys_user");
        List<User> resultList = nativeQuery.unwrap(NativeQuery.class)
                .setTupleTransformer(new MyResultTransformer(User.class)).getResultList();
        System.out.println(resultList);

    }

}
