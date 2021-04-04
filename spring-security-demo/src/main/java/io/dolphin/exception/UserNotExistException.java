package io.dolphin.exception;

import lombok.Data;

/**
 * @author Eric
 * @create 2019 07 20 8:52
 */
@Data
public class UserNotExistException extends RuntimeException {

    private static final long serialVersionUID = -1675229331001861737L;

    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }
}
