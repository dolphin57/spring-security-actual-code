package io.dolphin.dto;

import com.fasterxml.jackson.annotation.JsonView;
import io.dolphin.validator.MyConstraint;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author Eric
 * @create 2019 07 13 17:15
 */
@Data
public class User {
    private String id;
    @MyConstraint(message = "这是一个测试")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @Past(message = "生日必须是过去的时间")
    private Date birthday;

    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }
}
