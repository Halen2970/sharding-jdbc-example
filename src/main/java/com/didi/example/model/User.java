package com.didi.example.model;


import com.didi.example.dto.UserDto;
import com.didi.example.lib.DateUtil;
import lombok.*;

import java.util.Date;

/**
 * @author huangjin
 */
@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long userId;
    private String name;
    private String mobile;
    private Date createTime;
    private Date updateTime;
    private Boolean isDeleted;

    public UserDto toDto() {
        UserDto userDto =  UserDto.builder()
            .userId(getUserId())
            .name(getName())
            .mobile(getMobile())
            .createTime(getCreateTime())
            .updateTime(getUpdateTime())
            .build();
        return userDto;
    }

    public static User fromDto(UserDto dto) {
        User user =  User.builder()
            .userId(dto.getUserId())
            .name(dto.getName())
            .mobile(dto.getMobile())
            .createTime(dto.getCreateTime())
            .updateTime(dto.getUpdateTime())
            .build();
        return user;
    }
}
