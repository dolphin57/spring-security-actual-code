package io.dolphin.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.dolphin.dto.User;
import io.dolphin.exception.UserNotExistException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * 用户接入层
 *
 * @author Eric
 * @create 2019 07 13 17:12
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(/*@RequestParam*/ String username) {
        System.out.println(username);
        List<User> users = Arrays.asList(new User(), new User(), new User());
        return users;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    @ApiOperation(value = "用户查询服务")
    public User getInfo(@ApiParam(value = "用户id") @PathVariable String id) {
        System.out.println("进入getInfo服务");

        User user = new User();
        user.setUsername("tom");
        return user;

        //throw new UserNotExistException(id);
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }

    @PutMapping(value = "/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                //FieldError fieldError = (FieldError)error;
                //String message = fieldError.getField() + " " + error.getDefaultMessage();
                System.out.println(error.getDefaultMessage());
            });
        }

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }

    @DeleteMapping(value = "/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }

    @GetMapping("/me")
    public Object getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("/me2")
    public Object getCurrentUser2(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/me3")
    public Object getCurrentUser3(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }
}
