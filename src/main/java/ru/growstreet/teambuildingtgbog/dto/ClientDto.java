package ru.growstreet.teambuildingtgbog.dto;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class ClientDto {

    private long telegramId;
    private long chatId;
    private String username;
}
