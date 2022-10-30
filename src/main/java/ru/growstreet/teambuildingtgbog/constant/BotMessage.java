package ru.growstreet.teambuildingtgbog.constant;

public enum BotMessage {

    START_MESSAGE("Start message"),
    HELP_MESSAGE("Help message"),
    UNKNOWN_COMMAND_MESSAGE("*Неизвестная команда!*\n" +
            "Используйте *\"" + ButtonName.HELP_BUTTON.getButtonName() + "\"* для получения доступных команд.\n"),
    REDIRECT_TO_MAIN_MENU_BUTTON("Перенаправление в главное меню"),
    CHOOSE_TO_CHANGE("Выберите, что хотели бы изменить");

    private final String message;

    BotMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
