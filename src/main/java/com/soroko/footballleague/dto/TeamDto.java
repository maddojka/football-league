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
public class TeamDto {
    String name;
    String city;
    String stadium;
}
