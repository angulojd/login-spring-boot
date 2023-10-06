package com.example.login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import com.example.login.repositories.UserRepository;
import com.example.login.models.UserModel;

import com.example.login.services.MessageService;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public Map<String, Object> saveUser(UserModel user) {
        Optional<UserModel> userOptional = userRepository.findByUsername(user.getUsername());
        if (userOptional.isPresent()) {
            MessageService message = new MessageService(
                400, "El usuario ya se encuentra registrado", null
                );
            return message.getMessage();
        }
        userRepository.save(user);
        MessageService message = new MessageService(
            201, "Usuario creado exitosamente", null
            );
        return message.getMessage();
    }

    @Transactional
    public Map<String, Object> authUser(String username, String password) {
        Optional<UserModel> userOptional = userRepository.findByUsernameAndPassword(username, password);

        // Crear un mapa o una clase Java que desees convertir en JSON
        Map<String, Object> data = new HashMap<>();
        if (!userOptional.isPresent()) {
            MessageService message = new MessageService(
                404, "Usuario no encontrado", null
                );
            return message.getMessage();
        }

        data.put("id", userOptional.get().getId());

        MessageService message = new MessageService(
            200, "Usuario encontrado", data
            );
        return message.getMessage();
    }

    @Transactional
    public Map<String, Object> getUser(Long id) {
        Optional<UserModel> userOptional = userRepository.findById(id);

        // Crear un mapa o una clase Java que desees convertir en JSON
        Map<String, Object> data = new HashMap<>();
        if (!userOptional.isPresent()) {
            MessageService message = new MessageService(
                404, "Usuario no encontrado", null
                );
            return message.getMessage();
        }

        data.put("username", userOptional.get().getUsername());
        data.put("firstName", userOptional.get().getFirstName());
        data.put("lastName", userOptional.get().getLastName());
        data.put("phone", userOptional.get().getPhone());
        data.put("email", userOptional.get().getEmail());
        data.put("address", userOptional.get().getAddress());

        MessageService message = new MessageService(
            200, "Usuario encontrado", data
            );
        return message.getMessage();
    }
}
