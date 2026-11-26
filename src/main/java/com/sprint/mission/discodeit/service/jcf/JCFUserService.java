package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.UserService;

import java.util.*;

public class JCFUserService implements UserService {
    private final Map<UUID, User> data;

    public JCFUserService() {
        this.data = new HashMap<>();
    }

    @Override
    public User create(String username, String email, String password) {
        User user = new User(username, email, password);
        data.put(user.getId(), user);
        return user;
    }

    @Override
    public User find(UUID id) {
        User user = data.get(id);
        if (user == null) {
            throw new NoSuchElementException("User를 찾을 수 없습니다. id = " + id);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return data.values().stream().toList();
    }

    @Override
    public User update(UUID id, String username, String email, String password) {
        User user = find(id);
        user.updata(username, email, password);
        return user;
    }

    @Override
    public void delete(UUID id) {
        if (data.remove(id) == null) {
            throw new NoSuchElementException("User를 찾을 수 없습니다. id = " + id);
        }
    }
}
