package com.kbg.jpa.dto;

import java.util.List;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ocir_user")
public class UserEntity {
    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers;
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<Extension> extensions;
}
