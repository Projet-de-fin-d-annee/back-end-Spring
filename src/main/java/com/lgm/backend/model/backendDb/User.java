package com.lgm.backend.model.backendDb;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "password", nullable = false)
    String password;

    @Column(nullable = false)
    Float point = 250F;

    @Lob
    @Column(name = "profile_photo", columnDefinition = "LONGBLOB")
    byte[] profilePhoto;

    @Column(name = "description")
    String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    List<Role> roles;

    public User(String firstName, String lastName, String email, String password, List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(String email, String password, List<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        this.roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.email;
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
