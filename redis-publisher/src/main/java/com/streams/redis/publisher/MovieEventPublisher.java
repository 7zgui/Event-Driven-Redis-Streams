package com.streams.redis.publisher;

import com.streams.redis.dto.MovieDetails;
import com.streams.redis.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mohamed ouokki on 11/14/22
 * @project redis
 */
@Service
@Slf4j
public class MovieEventPublisher {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Value("${stream.key}")
    private String streamKey;

    private final MovieRepository movieRepository;

    private final ReactiveRedisTemplate<String, String> redisTemplate;


    public MovieEventPublisher(MovieRepository repository, ReactiveRedisTemplate<String, String> redisTemplate) {
        this.movieRepository = repository;
        this.redisTemplate = redisTemplate;
    }

    @Scheduled(fixedRateString= "${publish.rate}")
    public void publishEvent(){
        MovieDetails movieDetails = this.movieRepository.getRandomMovie();
        log.info("Movie Details :: "+movieDetails);
        ObjectRecord<String, MovieDetails> record = StreamRecords.newRecord()
                .ofObject(movieDetails)
                .withStreamKey(streamKey);
        this.redisTemplate
                .opsForStream()
                .add(record)
                .subscribe(System.out::println);
        atomicInteger.incrementAndGet();
    }

    @Scheduled(fixedRate = 10000)
    public void showPublishedEventsSoFar(){
        log.info("Total Events :: " +atomicInteger.get());
    }

}
