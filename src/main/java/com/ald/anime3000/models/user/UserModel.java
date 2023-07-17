package com.ald.anime3000.models.user;

import com.ald.anime3000.enums.RoleUser;
import com.ald.anime3000.enums.StatusUser;
import com.ald.anime3000.models.person.PersonModel;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Data
@Entity
@Table(name = "T_USER" ,schema = "system")
public class UserModel implements UserDetails, Serializable {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userId")
    private PersonModel personId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusUser statusUser;
    @Enumerated(EnumType.STRING)
    private RoleUser roleUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.username;
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
