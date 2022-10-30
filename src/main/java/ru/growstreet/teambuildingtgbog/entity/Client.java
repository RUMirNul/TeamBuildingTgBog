package ru.growstreet.teambuildingtgbog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.growstreet.teambuildingtgbog.constant.Role;
import ru.growstreet.teambuildingtgbog.constant.State;

import javax.persistence.*;

@Entity
@Table(name = "client")
@Getter
@Setter
@Accessors(chain = true)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "telegram_id", unique = true)
    private long telegramId;

    @Column(name = "chat_id")
    private long chatId;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private State state = State.DEFAULT;
}
