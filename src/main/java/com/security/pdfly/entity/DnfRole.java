package com.security.pdfly.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "dnf_role")
@Data
@SequenceGenerator(name = "seq_gen_dnf_role", sequenceName = "seq_dnf_role")
public class DnfRole {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dnf_role")
    private Integer id;

    @Column(nullable = false)
    private String career;

    @Column(nullable = false)
    private Integer power;

    private Long damage_15s;

    private Long damage_20s;
}
