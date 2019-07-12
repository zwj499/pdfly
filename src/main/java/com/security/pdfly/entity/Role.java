package com.security.pdfly.entity;

import com.security.pdfly.entity.base.BaseModel;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "role")
@Data
@EntityListeners(AuditingEntityListener.class)
@SequenceGenerator(name = "seq_gen_role", sequenceName = "seq_role")
public class Role extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen_role")
    private Integer id;

    @Column(length = 100)
    private String name;

    @Column(length = 200)
    private String note;

    @CreatedDate
    private Date create_time;

    @LastModifiedDate
    private Date update_time;

}
