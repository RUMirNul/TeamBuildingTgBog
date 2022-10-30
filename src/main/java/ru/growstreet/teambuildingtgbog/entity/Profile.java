package ru.growstreet.teambuildingtgbog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "profile")
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "full_name")
    private String fillName = "";

    @Column(name = "age")
    private int age = 20;

    @Column(name = "city")
    private String city = "";

    @Column(name = "position")
    private String position = "";

    @Column(name = "department")
    private String department = "";

    @Column(name = "about_oneself")
    private String aboutOneself = "";

    @Column(name = "photo_id")
    private String photoId = "AgACAgIAAxkBAAMfY14AATvpR_G9lgXckQhnbEeyiWfSAAJTwDEbVe3wShzSanfiEi-FAQADAgADcwADKgQ";

    @Column(name = "active")
    private boolean active = false;
}
