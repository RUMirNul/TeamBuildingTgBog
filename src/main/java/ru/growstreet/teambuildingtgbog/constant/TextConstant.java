package ru.growstreet.teambuildingtgbog.constant;

public class TextConstant {
    public static final String start = "/start";
    public static final String help = "Помощь";
    public static final String inMainMenu = "В главное меню";

    //Анкета
    public static final String editProfile = "Редактировать анкету";
    public static final String showProfile = "Показать анкету";
    public static final String editFullName = "Изменить имя";
    public static final String editCity = "Изменить страну/город";
    public static final String editPosition = "Изменить должность";
    public static final String editDepartment = "Изменить департамент";
    public static final String editAboutOneself = "Изменить о себе";
    public static final String editPhoto = "Изменить фото";
    public static final String editActive = "Изменить показ объявления";
    public static final String editInterests = "Изменить интересы";

    //Вспомогательные сообщения

    public static final String profilePattern = "*{fullName}\n*" +
            "*Возраст:* {age}\n" +
            "*Страна/город:* {city}\n" +
            "*Должность:* {position}\n" +
            "*Отдел:* {department}\n" +
            "*Обо мне:* {about}\n" +
            "*TG:* @{tg}";

}
