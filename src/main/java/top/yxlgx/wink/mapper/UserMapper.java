package top.yxlgx.wink.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.yxlgx.wink.entity.User;

import java.util.List;

@Mapper
public interface UserMapper{
    List<User> getUserByLikeName(String name);
}
