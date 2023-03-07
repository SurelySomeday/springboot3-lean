package top.yxlgx.wink.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import top.yxlgx.wink.entity.base.BaseEntity;

import java.io.Serializable;
import java.util.Set;

/**
 * @author yanxin
 * @Description:
 */
@Getter
@Setter
@Entity
@Table(name = "sys_role", indexes = {
        @Index(name = "sys_role_name",columnList = "name", unique = true)
}
)
@NamedEntityGraph(
        name = "role.all",
        attributeNodes =  {
                @NamedAttributeNode("permissions")
        }
)
public class Role extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name = "sys_roles_permissions",
            joinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            indexes = {@Index(name="sys_users_roles_unique",columnList = "role_id,permission_id",unique = true)}
    )
    private Set<Permission> permissions;
}
