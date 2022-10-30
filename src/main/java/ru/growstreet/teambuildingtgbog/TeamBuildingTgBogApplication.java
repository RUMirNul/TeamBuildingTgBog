package ru.growstreet.teambuildingtgbog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class TeamBuildingTgBogApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamBuildingTgBogApplication.class, args);
    }

}
