package com.test.api.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "'user'")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;
    @Lob
    @Lazy
    @Column(columnDefinition = "bytea")
    private byte[] avatar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;
}
