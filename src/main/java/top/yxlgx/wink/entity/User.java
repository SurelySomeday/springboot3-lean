package top.yxlgx.wink.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @Author yanxin.
 * @Date 2023/3/6 9:57.
 * Created by IntelliJ IDEA
 * File Description:
 */
@NamedEntityGraph(
        name = "user.all",
        attributeNodes =  {
                @NamedAttributeNode("address")
        }
)
@Data
@Entity(name = "sys_user")
public class User {
    @Id
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "age")
    Integer age;
//    @Column(name = "address_id")
//    Long addressId;
    @OneToOne(cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    Address address;
}
