package com.security.pdfly.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "skill")
@Data
@SequenceGenerator(name = "seq_gen_skill", sequenceName = "seq_skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_skill")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false, name = "skill_damage")
    private Long skillDamage;

    @Column(nullable = false, name = "dnf_role")
    private Integer dnfRoleId;
}
