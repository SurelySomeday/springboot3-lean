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
import top.yxlgx.wink.entity.Permission;
import top.yxlgx.wink.entity.Role;
import top.yxlgx.wink.entity.User;
import top.yxlgx.wink.mapper.UserMapper;
import top.yxlgx.wink.repository.PermissionRepository;
import top.yxlgx.wink.repository.RoleRepository;
import top.yxlgx.wink.repository.UserRepository;

import java.util.*;

@SpringBootTest
class LearnDemoApplicationTests {

    @Resource
    UserRepository userRepository;
    @Resource
    RoleRepository roleRepository;
    @Resource
    PermissionRepository permissionRepository;


    @SuppressWarnings("unchecked")
    @Test
    void contextLoads() {
        Optional<Role> roleOptional = roleRepository.findById(1L);
        Optional<User> userOptional = userRepository.findById(1L);
        Optional<Permission> permissionOptional = permissionRepository.findById(1L);

        Permission permission = permissionOptional.get();
        User user = userOptional.get();
        Role role = roleOptional.get();
        role.setPermissions(Set.of(permission));
        user.setRoles(Set.of(role));
        //roleRepository.save(role);
        userRepository.save(user);
        Iterable<User> all = userRepository.findAll();
        System.out.println(all);
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
        encode = bCryptPasswordEncoder.encode("admin");
        System.out.println(encode);
    }

}
