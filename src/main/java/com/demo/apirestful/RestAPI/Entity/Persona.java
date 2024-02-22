package com.demo.apirestful.RestAPI.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Persona implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String name;
    @NotBlank(message = "Favor colocar su correo electrónico")
    @Email(message = "Por favor colocar un formato de correo que sea correcto. Ejemplo: (aaaaaaa@dominio.cl)")
    private String email;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Phones> phones = new ArrayList<>();
    @CreationTimestamp
    @JsonIgnore
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    @JsonIgnore
    LocalDateTime lastUpdated;
    @CurrentTimestamp
    @JsonIgnore
    private LocalDateTime lastLogin;
    private boolean isEnabled;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return name;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return isEnabled;
    }
}
