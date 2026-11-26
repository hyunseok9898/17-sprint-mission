package com.sprint.mission.discodeit.factory;

import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;
import com.sprint.mission.discodeit.service.jcf.JCFChannelService;
import com.sprint.mission.discodeit.service.jcf.JCFMessageService;
import com.sprint.mission.discodeit.service.jcf.JCFUserService;

public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();   // ② 딱 하나

    private final UserService userService;
    private final ChannelService channelService;
    private final MessageService messageService;

    private ServiceFactory() {                                             // ① 밖에서 new 금지
        this.userService = new JCFUserService();
        this.channelService = new JCFChannelService();
        this.messageService = new JCFMessageService(userService, channelService);   // 같은 객체 주입
    }

    public static ServiceFactory getInstance() {                           // ③ 하나를 꺼내 줌
        return INSTANCE;
    }

    public UserService getUserService() {
        return userService;
    }

    public ChannelService getChannelService() {
        return channelService;
    }

    public MessageService getMessageService() {
        return messageService;
    }
}