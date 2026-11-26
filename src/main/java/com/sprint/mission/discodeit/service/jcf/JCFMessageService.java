package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.service.MessageService;

import java.util.*;

public class JCFMessageService implements MessageService {
   private final Map<UUID, Message> data;

   public JCFMessageService() {
       this.data = new HashMap<>();
   }

    @Override
    public Message create(String content, UUID channelId, UUID authorId) {
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
