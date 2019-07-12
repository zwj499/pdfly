package com.security.pdfly.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.security.pdfly.entity.base.BaseModel;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@EntityListeners(AuditingEntityListener.class)
@SequenceGenerator(name = "seq_gen_user", sequenceName = "seq_user")
public class User extends BaseModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    private Integer id;

    @Column(length = 100, nullable = false)
    private String username;

    @Column(length = 200, nullable = false)
    @JsonIgnore
    private String password;

    @Column(length = 200)
    @JsonIgnore
    private String salt;

    @CreatedDate
    private Date create_time;

    @LastModifiedDate
    private Date update_time;

    @JsonIgnore
    @Transient
    private List<Role> roleList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = this.roleList;
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
