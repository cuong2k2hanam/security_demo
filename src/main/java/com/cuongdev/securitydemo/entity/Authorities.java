package com.cuongdev.securitydemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        indexes = {
                @Index(name = "idx_auth_username", columnList = "username, authority")
        }
)
public class Authorities {
    @Id
    @SequenceGenerator(
            name = "authorities_sequence",
            sequenceName = "authorities_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "authorities_sequence"
    )
    private long authorityId;
    @OneToOne
    @JoinColumn(
            name = "username",
            referencedColumnName = "username"
    )
    private Users users;
    private String authority;
}
