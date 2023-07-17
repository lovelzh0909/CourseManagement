package com.example.coursemanagement.response;

import lombok.Data;

@Data
public class AvatarReturnType {
    private String url;

    public static AvatarReturnType create(String result){
        AvatarReturnType avatarReturnType = new AvatarReturnType();
        avatarReturnType.setUrl(result);
        return avatarReturnType;
    }
}
