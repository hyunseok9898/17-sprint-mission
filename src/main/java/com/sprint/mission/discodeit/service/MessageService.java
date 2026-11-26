package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.Message;

import java.util.*;

public interface MessageService {
    Message create(String content, UUID channelId, UUID authorId);

    Message find(UUID id);

    List<Message> findAll();

    Message update(UUID id, String content);

    void delete(UUID id);
}
