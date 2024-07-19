package com.kbg.jpa.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ocir_user_extension")
public class Extension {
    @EmbeddedId
    private ExtensionId extensionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName="user_id", insertable = false, updatable = false)
    private UserEntity userEntity;
}
