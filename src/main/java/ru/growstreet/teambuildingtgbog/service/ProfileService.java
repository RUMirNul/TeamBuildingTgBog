package ru.growstreet.teambuildingtgbog.service;

import org.springframework.stereotype.Service;
import ru.growstreet.teambuildingtgbog.entity.Profile;
import ru.growstreet.teambuildingtgbog.repository.ProfileRepository;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile createProfile(long clientId) {
        Profile checkedProfile = profileRepository.getProfileByClientId(clientId);
        if (checkedProfile == null) {
            Profile profile = new Profile();
            profile.setClientId(clientId);

            return profileRepository.save(profile);
        } else {
            return checkedProfile;
        }

    }

    public Profile getProfileByClientId(long clientId) {
        return profileRepository.getProfileByClientId(clientId);
    }
}
