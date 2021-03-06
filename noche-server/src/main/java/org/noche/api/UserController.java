package org.noche.api;

import dto.UserInfo;
import org.noche.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Timi on 4/7/2017.
 */
@RestController
public class UserController {

    /* --- Static members --- */

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    /* --- Members --- */

    @Autowired
    private UserService userService;

    /* --- Public methods --- */

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public void createUser(@RequestBody UserInfo userInfo) {
        // TODO get credentials
        userService.createUser(userInfo.getName(), userInfo.getEmail(), userInfo.getGender(), userInfo.getAge());
    }

}
