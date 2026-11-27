package com.sprint.mission.discodeit.service.file;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.UserService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Stream;

public class FileUserService implements UserService {
    private final Path directory;

    public FileUserService() {
        this.directory = Paths.get(System.getProperty("user.dir"), "data", "user");
        init();
    }

    private void init() {
        try {
            Files.createDirectories(directory);
        } catch (IOException e) {
            throw new UncheckedIOException("저장 폴더를 만들 수 없습니다: " + directory, e);
        }
    }

    private Path resolvePath(UUID id) {
        return directory.resolve(id + ".ser");      // data/user/[id].ser
    }

    private void save(User user) {
        try
            (ObjectOutputStream oos = new ObjectOutputStream(
                    Files.newOutputStream(resolvePath(user.getId())))) {
                oos.writeObject(user);
            } catch (IOException e) {
            throw new UncheckedIOException("User를 저장할 수 없습니다. id=" + user.getId(), e);
        }
    }

    private User load(Path path) {
        try (ObjectInputStream ois = new ObjectInputStream((Files.newInputStream(path)))) {
            return (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalStateException("User 파일을 읽을 수 없습니다: " + path, e);
        }
    }

    @Override
    public User create(String username, String email, String password) {
        User user = new User(username, email, password);
        save(user);
        return user;
    }

    @Override
    public User find(UUID id) {
        Path path = resolvePath(id);
        if (Files.notExists(path)) {
            throw new NoSuchElementException("User를 찾을 수 없습니다. id = " + id);
        }
        return load(path);
    }

    @Override
    public List<User> findAll() {
        try (Stream<Path> paths = Files.list(directory)) {
            return paths
                    .filter(path -> path.toString().endsWith(".ser"))
                    .map(this::load)
                    .toList();
        } catch (IOException e) {
            throw new UncheckedIOException("User 목록을 읽을 수 없습니다.", e);
        }
    }

    @Override
    public User update(UUID id, String username, String email, String password) {
        throw new UnsupportedOperationException("5번 작업에서 구현");
    }

    @Override
    public void delete(UUID id) {
        throw new UnsupportedOperationException("5번 작업에서 구현");
    }
}
