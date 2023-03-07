package top.yxlgx.wink.repository;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.NamedEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphCrudRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphPagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import top.yxlgx.wink.entity.Permission;
import top.yxlgx.wink.entity.Role;

import java.util.Optional;

/**
 * @Author yanxin.
 * @Date 2023/3/6 13:12.
 * Created by IntelliJ IDEA
 * File Description:
 */
@Repository
public interface PermissionRepository extends EntityGraphCrudRepository<Permission,Long>,
        EntityGraphPagingAndSortingRepository<Permission,Long>,
        JpaSpecificationExecutor<Permission> {
    @Override
    default Optional<EntityGraph> defaultEntityGraph() {
        return Optional.empty();
    }
}
