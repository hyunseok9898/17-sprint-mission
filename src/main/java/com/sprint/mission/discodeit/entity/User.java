package com.sprint.mission.discodeit.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // 공통 필드
    private final UUID id;
    private final Long createdAt;
    private Long updatedAt;

    // 고유 필드
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
        this.username = username;
        this.email = email;
        this. password = password;
    }

    public UUID getId() {
        return id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void updata(String username, String email, String password) {
        boolean changed = false;

        if (username != null && !username.equals(this.username)) {
            this.username = username;
            changed = true;
        }
        if (email != null && !email.equals(this.email)) {
            this.email = email;
        }
        if (password != null && !password.equals(this.password)) {
            this.password = password;
            changed = true;
        }

        if (changed) {
            this.updatedAt = System.currentTimeMillis();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", id=" + id +
                '}';
    }
}


