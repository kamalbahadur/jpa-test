package com.kbg.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kbg.jpa.dao.UserRepo;
import com.kbg.jpa.dto.User;
import com.kbg.jpa.dto.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;

@RestController
public class Controller {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private UserRepo userRepo;

    @PostConstruct
    public void init() {
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<User> getUser(@RequestParam String userId) throws JsonProcessingException {
        UserEntity userEntity = userRepo.getReferenceById(userId);
        User user = User.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .userId(userEntity.getUserId())
                .build();

        user.setPhoneNumbers(userEntity.getPhoneNumbers().stream().map(e -> e.getPhoneNumberId().getPhoneNumber()).collect(Collectors.toList()));
        user.setExtensions(userEntity.getExtensions().stream().map(e -> e.getExtensionId().getExtension()).collect(Collectors.toList()));
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
