package com.soroko.footballleague.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author yuriy.soroko
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HolderDTO {
    String fullName;
    String email;
    String teamName;

    @Override
    public String toString() {
        return "HolderDTO{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
