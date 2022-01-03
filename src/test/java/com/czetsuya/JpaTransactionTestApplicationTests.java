package com.czetsuya;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.czetsuya.model.Anime;
import com.czetsuya.model.AnimeCharacter;
import com.czetsuya.repository.AnimeRepository;
import com.czetsuya.service.AnimeService;

@SpringBootTest
class JpaTransactionTestApplicationTests {

    //@Autowired
    //private AnimeService animeService;

    //@Autowired
    //private AnimeRepository animeRepository;

    //private Anime anime;

    @Test
    void contextLoads() {
    }

        /*
    @BeforeEach
    public void init() {
        anime = new Anime("Gundam Seed");
    }


    @Test
    public void create_saveOk() {

        Long animeId = animeService.create(anime);
        Optional<Anime> gundamSeed = animeRepository.findById(animeId);

        assertThat(gundamSeed).isPresent();

        List<AnimeCharacter> ac = gundamSeed.get().getAnimeCharacters();

        assertThat(ac).hasSize(1);
        assertThat(ac.get(0).getFirstName()).isEqualTo("Kira");
    }
    */

}
