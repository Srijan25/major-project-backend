package com.learn.portal.entites;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
@Table(name = "users")
//@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name", nullable = false, length = 50)
    private String name;

    @Column(name = "user_mobileNumber", nullable = false, length = 10)
    private String mobileNumber;

    @Column(name = "user_emailId", nullable = false, length = 50)
    private String emailId;

    @Column(name = "user_password", nullable = false, length = 1000)
    private String password;

    @Column(name = "user_role", nullable = false, length = 10)
    private String role;

    @Column(name = "student_roll", nullable = true, length = 50)
    private int studentRoll;

    @Column(name = "semester", nullable = true, length = 10)
    private int semester;
    
    //@OneToMany(mappedBy = "teacher")
    //private List<Subject> subjects;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;

    @Column(name = "user_image", length = 50)
    private String userImage;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> roles = new ArrayList<>();
        roles.add(this.role);
        return roles.stream().map(SimpleGrantedAuthority::new).collect(toList());

    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.emailId;
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

