package ru.growstreet.teambuildingtgbog.service;

import org.springframework.stereotype.Service;
import ru.growstreet.teambuildingtgbog.dto.ClientDto;
import ru.growstreet.teambuildingtgbog.dto.ProfileDto;
import ru.growstreet.teambuildingtgbog.entity.Client;
import ru.growstreet.teambuildingtgbog.entity.Profile;

@Service
public class GeneralService {

    private final ClientService clientService;
    private final ProfileService profileService;

    public GeneralService(ClientService clientService, ProfileService profileService) {
        this.clientService = clientService;
        this.profileService = profileService;
    }

    public void create(ClientDto clientDto) {
        Client client = clientService.createClient(clientDto);
        profileService.createProfile(client.getId());
    }

    public ProfileDto getProfileByTgId(ClientDto clientDto) {
        Client client = clientService.getClientByTelegramId(clientDto.getTelegramId());
        if (client != null) {
            Profile profile = profileService.getProfileByClientId(client.getId());
            if (profile != null) {
                ProfileDto profileDto = new ProfileDto();
                profileDto.setFillName(profile.getFillName())
                        .setCity(profile.getCity())
                        .setAge(profile.getAge())
                        .setPosition(profile.getPosition())
                        .setDepartment(profile.getDepartment())
                        .setAboutOneself(profile.getAboutOneself())
                        .setPhotoId(profile.getPhotoId())
                        .setUsername(client.getUsername());
                return profileDto;
            } else {
                profileService.createProfile(client.getId());
                return getProfileByTgId(clientDto);
            }
        } else {
            create(clientDto);
            return getProfileByTgId(clientDto);
        }
    }

}
