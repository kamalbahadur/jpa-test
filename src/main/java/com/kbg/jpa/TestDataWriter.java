package com.kbg.jpa;

import com.kbg.jpa.dao.UserRepo;
import com.kbg.jpa.dto.Extension;
import com.kbg.jpa.dto.ExtensionId;
import com.kbg.jpa.dto.PhoneNumber;
import com.kbg.jpa.dto.PhoneNumberId;
import com.kbg.jpa.dto.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Arrays;

@Component
@Transactional
public class TestDataWriter {

    @Autowired
    private UserRepo userRepo;

    @PostConstruct
    public void init() {
        String userId = "kamal.bahadur@gmail.com";
        PhoneNumberId phoneNumberId = new PhoneNumberId();
        phoneNumberId.setUserId(userId);
        phoneNumberId.setPhoneNumber("424 123 3456");

        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhoneNumberId(phoneNumberId);

        ExtensionId extensionId = new ExtensionId();
        extensionId.setUserId(userId);
        extensionId.setExtension("1234");

        Extension extension = new Extension();
        extension.setExtensionId(extensionId);

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("Kamal");
        userEntity.setLastName("Giri");
        userEntity.setUserId(userId);

        userEntity.setExtensions(Arrays.asList(extension));
        userEntity.setPhoneNumbers(Arrays.asList(phoneNumber));

        userRepo.saveAndFlush(userEntity);
    }
}
