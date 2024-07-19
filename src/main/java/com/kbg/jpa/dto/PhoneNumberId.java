package com.kbg.jpa.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class PhoneNumberId implements Serializable {
    @Column(name = "user_id", nullable = false)
    String userId;
    @Column(name = "phone_number", nullable = false)
    String phoneNumber;
}
