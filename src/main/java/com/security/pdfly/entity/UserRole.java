package com.security.pdfly.entity;

import com.security.pdfly.entity.base.BaseModel;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_role")
@Data
@EntityListeners(AuditingEntityListener.class)
@SequenceGenerator(name = "seq_gen_user_role", sequenceName = "seq_user_role")
public class UserRole extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen_user_role")
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @CreatedDate
    private Date create_time;

    @LastModifiedDate
    private Date update_time;
}
