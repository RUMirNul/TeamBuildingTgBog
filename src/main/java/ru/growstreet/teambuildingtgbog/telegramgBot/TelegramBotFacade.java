package ru.growstreet.teambuildingtgbog.telegramgBot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.growstreet.teambuildingtgbog.telegramgBot.handler.MessageHandler;

@Component
public class TelegramBotFacade {

    private final MessageHandler messageHandler;

    public TelegramBotFacade(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public BotApiMethod<?> handler(Update update){
        Message message = update.getMessage();

        if (message != null && message.hasText()) {
            return messageHandler.handler(message);

        } else if (message != null) {
            SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Unknown command");
            sendMessage.enableMarkdown(true);
            return sendMessage;
        }
        return new SendMessage();
    }
}
