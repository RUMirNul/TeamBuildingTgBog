package ru.growstreet.teambuildingtgbog.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProfileDto {

    private String fillName;
    private int age;
    private String city;
    private String position;
    private String department;
    private String aboutOneself;
    private String photoId;
    private String username;
}
