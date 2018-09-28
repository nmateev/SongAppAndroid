package com.wasp.songappspring;

import com.wasp.songappspring.models.Song;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SongappspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongappspringApplication.class, args);
    }


    @Bean
    public SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Song.class)
                .buildSessionFactory();
    }
}
