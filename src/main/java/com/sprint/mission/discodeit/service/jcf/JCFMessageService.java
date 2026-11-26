package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;

import java.util.*;

public class JCFMessageService implements MessageService {
   private final Map<UUID, Message> data;
   private final UserService userService;
   private final ChannelService channelService;

   public JCFMessageService(UserService userService, ChannelService channelService) {
       this.data = new HashMap<>();
       this.userService = userService;
       this.channelService = channelService;
   }

    @Override
    public Message create(String content, UUID channelId, UUID authorId) {
       userService.find(authorId);
       channelService.find(channelId);

        Message message = new Message(content, channelId, authorId);
        data.put(message.getId(), message);
        return message;
    }

    @Override
    public Message find(UUID id) {
       Message message = data.get(id);
       if (message == null) {
           throw new NoSuchElementException("Message를 찾을 수 없습니다. id=" + id);
       }
       return message;
    }

    @Override
    public List<Message> findAll() {
      return data.values().stream().toList();
    }

    @Override
    public Message update(UUID id, String content) {
        Message message = data.get(id);
        message.update(content);
        return message;
    }

    @Override
    public void delete(UUID id) {
        if (data.remove(id) == null){
            throw new NoSuchElementException("Message를 찾을 수 없습니다. id=" + id);
        }
    }
}
