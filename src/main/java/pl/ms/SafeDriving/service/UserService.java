package pl.ms.SafeDriving.service;

import pl.ms.SafeDriving.model.User;

public interface UserService {

    User findByUserEmail(String email);

    void saveUser(User user);

    void updateUser(User user);




}
