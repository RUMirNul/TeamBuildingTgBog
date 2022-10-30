package ru.growstreet.teambuildingtgbog.telegramgBot.keyboard;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.growstreet.teambuildingtgbog.constant.ButtonName;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReplyKeyboardMaker {

    public ReplyKeyboardMarkup getMainMenuKeyboard() {
        KeyboardRow firstRow = new KeyboardRow();


        firstRow.add(new KeyboardButton(ButtonName.SHOW_PROFILE_BUTTON.getButtonName()));
        firstRow.add(new KeyboardButton(ButtonName.EDIT_PROFILE_BUTTON.getButtonName()));
        firstRow.add(new KeyboardButton(ButtonName.HELP_BUTTON.getButtonName()));

        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(firstRow);

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup getEditProfileKeyboard() {
        KeyboardRow firstRow = new KeyboardRow();
        KeyboardRow secondRow = new KeyboardRow();
        KeyboardRow thirdRow = new KeyboardRow();

        firstRow.add(new KeyboardButton(ButtonName.EDIT_FULL_NAME_BUTTON.getButtonName()));
        firstRow.add(new KeyboardButton(ButtonName.EDIT_CITY_BUTTON.getButtonName()));
        firstRow.add(new KeyboardButton(ButtonName.EDIT_POSITION_BUTTON.getButtonName()));

        secondRow.add(new KeyboardButton(ButtonName.EDIT_DEPARTMENT_BUTTON.getButtonName()));
        secondRow.add(new KeyboardButton(ButtonName.EDIT_ABOUT_ONESELF_BUTTON.getButtonName()));
        secondRow.add(new KeyboardButton(ButtonName.EDIT_PHOTO_BUTTON.getButtonName()));

        thirdRow.add(new KeyboardButton(ButtonName.EDIT_ACTIVE_BUTTON.getButtonName()));
        thirdRow.add(new KeyboardButton(ButtonName.EDIT_INTERESTS_BUTTON.getButtonName()));
        thirdRow.add(new KeyboardButton(ButtonName.IN_MAIN_MENU_BUTTON.getButtonName()));


        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(firstRow);
        keyboard.add(secondRow);
        keyboard.add(thirdRow);

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        return replyKeyboardMarkup;
    }
}
