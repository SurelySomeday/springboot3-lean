package top.yxlgx.wink.controller;

import jakarta.annotation.Resource;
import jakarta.persistence.criteria.Predicate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import top.yxlgx.wink.config.security.service.JwtService;
import top.yxlgx.wink.entity.dto.LoginDTO;
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
    @Resource
    JwtService jwtService;

    @Resource
    AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtService.generateToken(loginDTO.getUsername());
    }

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
