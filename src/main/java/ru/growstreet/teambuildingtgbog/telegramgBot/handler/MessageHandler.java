package ru.growstreet.teambuildingtgbog.telegramgBot.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import ru.growstreet.teambuildingtgbog.constant.BotMessage;
import ru.growstreet.teambuildingtgbog.constant.TextConstant;
import ru.growstreet.teambuildingtgbog.dto.ClientDto;
import ru.growstreet.teambuildingtgbog.dto.ProfileDto;
import ru.growstreet.teambuildingtgbog.service.GeneralService;
import ru.growstreet.teambuildingtgbog.telegramgBot.keyboard.ReplyKeyboardMaker;
import ru.growstreet.teambuildingtgbog.telegramgBot.service.CustomSendMessage;

@Component
public class MessageHandler {

    private final ReplyKeyboardMaker replyKeyboardMaker;
    private final GeneralService generalService;

    public MessageHandler(ReplyKeyboardMaker replyKeyboardMaker, GeneralService generalService) {
        this.replyKeyboardMaker = replyKeyboardMaker;
        this.generalService = generalService;
    }

    public BotApiMethod<?> handler(Message message) {

        String inputData = message.getText();
        String chatId = message.getChatId().toString();
        Long userId = message.getFrom().getId();
        //TODO ....
        switch (inputData) {
            case TextConstant.start:
                createUserAndProfile(message);
                return getConstructorMessage(chatId, BotMessage.START_MESSAGE.getMessage(), replyKeyboardMaker.getMainMenuKeyboard());
            case TextConstant.help:
                createUserAndProfile(message);
                return getConstructorMessage(chatId, BotMessage.HELP_MESSAGE.getMessage(), replyKeyboardMaker.getMainMenuKeyboard());
            case TextConstant.inMainMenu:
                return getConstructorMessage(chatId, BotMessage.REDIRECT_TO_MAIN_MENU_BUTTON.getMessage(), replyKeyboardMaker.getMainMenuKeyboard());
            case TextConstant.editProfile:
                return getConstructorMessage(chatId, BotMessage.CHOOSE_TO_CHANGE.getMessage(), replyKeyboardMaker.getEditProfileKeyboard());
            case TextConstant.showProfile:
                sendShowProfileMessage(message);
                return new SendMessage();
            case TextConstant.editFullName:
                return null;
            case TextConstant.editCity:
                return null;
            case TextConstant.editPosition:
                return null;
            case TextConstant.editDepartment:
                return null;
            case TextConstant.editAboutOneself:
                return null;
            case TextConstant.editPhoto:
                return null;
            case TextConstant.editActive:
                return null;
            case TextConstant.editInterests:
                return null;
        }

        return null;
    }

    private SendMessage getConstructorMessage(String chatId, String text, ReplyKeyboardMarkup replyKeyboardMarkup) {
        SendMessage sendMessage = new SendMessage(chatId, text);
        sendMessage.enableMarkdown(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }

    private void sendShowProfileMessage(Message message) {
        ClientDto clientDto = getClientDtoFromMessage(message);
        ProfileDto profileDto = generalService.getProfileByTgId(clientDto);

        String text = TextConstant.profilePattern.replace("{fullName}", profileDto.getFillName())
                .replace("{age}", String.valueOf(profileDto.getAge()))
                .replace("{city}", profileDto.getCity())
                .replace("{position}", profileDto.getPosition())
                .replace("{department}", profileDto.getDepartment())
                .replace("{about}", profileDto.getAboutOneself())
                .replace("{tg}", profileDto.getUsername());

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId().toString());
        sendPhoto.setPhoto(new InputFile(profileDto.getPhotoId()));
        sendPhoto.setCaption(text);
        sendPhoto.setReplyMarkup(replyKeyboardMaker.getEditProfileKeyboard());

        CustomSendMessage customSendMessage = new CustomSendMessage(sendPhoto);
        customSendMessage.send();

    }

    private void createUserAndProfile(Message message) {
        ClientDto clientDto = getClientDtoFromMessage(message);

        generalService.create(clientDto);

    }

    private ClientDto getClientDtoFromMessage(Message message) {
        ClientDto clientDto = new ClientDto();
        clientDto.setChatId(message.getChatId())
                .setTelegramId(message.getFrom().getId())
                .setUsername(message.getFrom().getUserName());

        return clientDto;
    }


}
