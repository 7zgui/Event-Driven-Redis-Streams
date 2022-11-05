package com.redis.streams.redispublisher.repositories;

import com.redis.streams.redispublisher.dto.MovieDetailsDto;
import com.redis.streams.redispublisher.dto.MovieDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Mohamed ouokki on 11/5/22
 * @project redis-publisher
 */
@Repository
public class MovieRepository {
    public static final List<MovieDto> MOVIE_LIST = Stream.of(
            new MovieDto(1, "Avengers End Game", "Marvel Studios"),
            new MovieDto(2, "Avengers Infinity War", "Marvel Studios"),
            new MovieDto(3, "Dark Knight", "Warner Bros"),
            new MovieDto(4, "Pulp Fiction", "MiraMax"),
            new MovieDto(5, "Fight Club", "Warner Bros"),
            new MovieDto(6, "Good Fellas", "Warner Bros"),
            new MovieDto(7, "Seven", "Warner Bros"),
            new MovieDto(8, "Cast Away", "ImageMovers Playtone"),
            new MovieDto(9, "Forest Gump", "The Tisch Company"),
            new MovieDto(10, "King Kong", "Warner Bros"),
            new MovieDto(11, "The Silence Of Lambs", "Strong Heart Productions"),
            new MovieDto(12, "Usual Suspects", "PolyGram Filmed Entertainment"),
            new MovieDto(13, "Green Mile", "Castle Rock Entertainment"),
            new MovieDto(14, "No Country For Old Men", "Scott Rudin Productions"),
            new MovieDto(15, "Train to Busan", "Next Entertainment World"),
            new MovieDto(16, "Parasite", "Barunson E&A"),
            new MovieDto(17, "Whiplash", "Sony Pictures"),
            new MovieDto(18, "The Prestige", "Warner Bros"),
            new MovieDto(19, "Joker", "Warner Bros"),
            new MovieDto(20, "Old Boy", "Show East"),
            new MovieDto(21, "I Saw Devil", "Peppermint and company"),
            new MovieDto(22, "The Perfect Murder", "Warner Bros"),
            new MovieDto(23, "The Chaser", "Snow Box"),
            new MovieDto(24, "Goodwill Hunting", "Be Gentlemen"),
            new MovieDto(25, "Snatch", "Columbia Pictures")
    ).collect(Collectors.toList());

    public MovieDetailsDto getRandomMovie() {
        Integer index = ThreadLocalRandom.current().nextInt(0, 25);
        MovieDto movie = MOVIE_LIST.get(index);
        Random random = new Random();
        Integer value = random.ints(0, 1000).findFirst().getAsInt();
        Double rating = random.doubles(1.0, 10.0).findFirst().getAsDouble();
        return new MovieDetailsDto(movie, value % 2 == 0, value % 2 == 1,  rating);
    }
}
