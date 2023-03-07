package top.yxlgx.wink.entity;

import jakarta.persistence.*;
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
@Table(name = "sys_permission", indexes = {
        @Index(name = "sys_permission_name",columnList = "name", unique = true)
}
)
public class Permission extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

}
