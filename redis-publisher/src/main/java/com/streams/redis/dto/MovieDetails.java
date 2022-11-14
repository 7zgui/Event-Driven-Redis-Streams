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
public class MovieDetails {
    private Movie movie;
    private Boolean likes=false;
    private Boolean dislike=false;
    private Double rating;
}
