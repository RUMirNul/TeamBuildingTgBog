package ru.growstreet.teambuildingtgbog.service;

import org.springframework.stereotype.Service;
import ru.growstreet.teambuildingtgbog.dto.ClientDto;
import ru.growstreet.teambuildingtgbog.entity.Client;
import ru.growstreet.teambuildingtgbog.repository.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(ClientDto clientDto) {
        Client checkedClient = clientRepository.getClientByTelegramId(clientDto.getTelegramId());
        if (checkedClient == null) {
            Client client = new Client();
            client.setTelegramId(clientDto.getTelegramId())
                    .setChatId(clientDto.getChatId())
                    .setUsername(clientDto.getUsername());

            return clientRepository.save(client);
        } else {
            return checkedClient;
        }

    }

    public Client getClientByTelegramId(long telegramId) {
        return clientRepository.getClientByTelegramId(telegramId);
    }
}
