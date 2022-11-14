package com.streams.redis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mohamed ouokki on 11/14/22
 * @project redis
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Integer id;
    private String name;
    private String productionHouse;
}
