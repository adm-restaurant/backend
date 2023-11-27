package com.admrestaurant.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "users")
@JsonDeserialize(as = User.class)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    @JsonIgnore
    private String password;
    @Column(unique = true)
    @Nonnull
    private String name;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status = Status.INACTIVE;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(Optional.ofNullable(role).map(Role::name).orElse(null)));
    }
    @Override
    public boolean isAccountNonExpired() {
        return this.isUserActive();
    }
    @Override
    public boolean isAccountNonLocked() {
        return this.isUserActive();
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return this.isUserActive();
    }

    @Override
    public boolean isEnabled() {
        return this.isUserActive();
    }
    @Override
    public String getUsername() {
        return this.name;
    }

    private boolean isUserActive() {
        return Optional.ofNullable(this.status).map(status -> status.equals(Status.ACTIVE)).orElse(false);
    }
}
