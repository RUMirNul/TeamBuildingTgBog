package ru.growstreet.teambuildingtgbog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.growstreet.teambuildingtgbog.entity.Client;

@Repository
public interface ClientRepository extends  JpaRepository<Client, Long>{
    Client getClientByTelegramId(long telegramId);
}
