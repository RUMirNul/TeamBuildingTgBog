package ru.growstreet.teambuildingtgbog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.growstreet.teambuildingtgbog.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
