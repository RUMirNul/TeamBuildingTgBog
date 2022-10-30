package ru.growstreet.teambuildingtgbog.telegramgBot.service;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import ru.growstreet.teambuildingtgbog.config.ApplicationContextProvider;
import ru.growstreet.teambuildingtgbog.telegramgBot.TelegramBot;

public class CustomSendMessage {

    private SendPhoto sendPhoto;

    public CustomSendMessage(SendPhoto sendPhoto) {
        this.sendPhoto = sendPhoto;
    }

    @SneakyThrows
    public void send() {
        TelegramBot telegramBot = ApplicationContextProvider.getContext().getBean(TelegramBot.class);
        telegramBot.execute(sendPhoto);
    }

}
