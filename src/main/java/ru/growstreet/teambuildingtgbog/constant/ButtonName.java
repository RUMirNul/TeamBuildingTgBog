package ru.growstreet.teambuildingtgbog.constant;

public enum ButtonName {

    HELP_BUTTON(TextConstant.help),
    SHOW_PROFILE_BUTTON(TextConstant.showProfile),
    IN_MAIN_MENU_BUTTON(TextConstant.inMainMenu),
    EDIT_PROFILE_BUTTON(TextConstant.editProfile),
    EDIT_FULL_NAME_BUTTON(TextConstant.editFullName),
    EDIT_CITY_BUTTON(TextConstant.editCity),
    EDIT_POSITION_BUTTON(TextConstant.editPosition),
    EDIT_DEPARTMENT_BUTTON(TextConstant.editDepartment),
    EDIT_ABOUT_ONESELF_BUTTON(TextConstant.editAboutOneself),
    EDIT_PHOTO_BUTTON(TextConstant.editPhoto),
    EDIT_ACTIVE_BUTTON(TextConstant.editActive),
    EDIT_INTERESTS_BUTTON(TextConstant.editInterests);
    private final String buttonName;

    ButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}
