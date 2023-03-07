package top.yxlgx.wink.controller;

import jakarta.annotation.Resource;
import jakarta.persistence.criteria.Predicate;
import org.springframework.web.bind.annotation.*;
import top.yxlgx.wink.util.QueryHelp;
import top.yxlgx.wink.entity.User;
import top.yxlgx.wink.entity.dto.UserDTO;
import top.yxlgx.wink.repository.UserRepository;

/**
 * @author yanxin
 * @Description:
 */
@RestController
public class UserController {

    @Resource
    UserRepository userRepository;

    @GetMapping("/all")
    public Iterable<User> all(){
        return userRepository.findAll();
    }

    @PostMapping("/condition")
    public Iterable<User> condition(@RequestBody UserDTO userDTO){

        return userRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = QueryHelp.getPredicate(root, userDTO, criteriaBuilder);
            return criteriaQuery.where(predicate).getRestriction();
        });
    }
}
