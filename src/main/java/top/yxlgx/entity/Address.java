package top.yxlgx.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @Author yanxin.
 * @Date 2023/3/6 9:57.
 * Created by IntelliJ IDEA
 * File Description:
 */
@Data
@Entity(name = "sys_address")
public class Address {
    @Id
    Long id;
    @Column(name = "address")
    String address;
}
