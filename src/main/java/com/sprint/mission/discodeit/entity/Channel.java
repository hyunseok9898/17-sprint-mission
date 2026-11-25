package com.sprint.mission.discodeit.entity;

import java.util.UUID;

public class Channel {
    // 공통 필드
    private final UUID id;
    private final Long createdAt;
    private Long updatedAt;

    // 고유 필드
    public String name;
    private String description;

    public Channel(String name, String description) {
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = createdAt;
        this.name = name;
        this.description = description;
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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void update(String name, String description){
        boolean changed = false;

        if (name != null && !name.equals(this.name)) {
            this.name = name;
            changed = true;
        }
        if (description != null && !description.equals(this.description)) {
            this.description = description;
            changed = true;
        }

        if (changed) {
            this.updatedAt = System.currentTimeMillis();
        }
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
