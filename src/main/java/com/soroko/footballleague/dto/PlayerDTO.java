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
public class PlayerDTO {
    String name;
    String surname;
    String position;
}