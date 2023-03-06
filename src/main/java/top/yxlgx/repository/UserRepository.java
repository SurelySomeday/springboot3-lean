package top.yxlgx.repository;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.NamedEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphCrudRepository;
import org.springframework.stereotype.Repository;
import top.yxlgx.entity.User;

import java.util.Optional;

/**
 * @Author yanxin.
 * @Date 2023/3/6 13:12.
 * Created by IntelliJ IDEA
 * File Description:
 */
@Repository
public interface UserRepository extends EntityGraphCrudRepository<User,Long> {
    @Override
    default Optional<EntityGraph> defaultEntityGraph() {
        return NamedEntityGraph.loading("user.all").execute(Optional::of);
    }
}
