package kz.kaznitu.kinoteatr.services;

import kz.kaznitu.kinoteatr.models.User;

public interface UserService {
    public User findUserByLogin(String login);
    public void saveUser(User user);
}
