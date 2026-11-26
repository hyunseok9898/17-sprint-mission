package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.service.ChannelService;

import java.util.*;

public class JCFChannelService implements ChannelService {
    private final Map<UUID, Channel> data;

    public JCFChannelService() {
        this.data = new HashMap<>();
    }

    @Override
    public Channel create(String name, String description) {
        Channel channel = new Channel(name, description);
        data.put(channel.getId(), channel);
        return channel;
    }

    @Override
    public Channel find(UUID id) {
        Channel channel = data.get(id);
        if (channel == null) {
            throw new NoSuchElementException("Channel을 찾을 수 없습니다. id=" + id);
        }
        return channel;
    }

    @Override
    public List<Channel> findAll() {
        return data.values().stream().toList();
    }

    @Override
    public Channel update(UUID id, String name, String description) {
        throw new UnsupportedOperationException("12번 작업에서 구현");
    }

    @Override
    public Channel delete(UUID id) {
        throw new UnsupportedOperationException("12번 작업에서 구현");
    }
}
