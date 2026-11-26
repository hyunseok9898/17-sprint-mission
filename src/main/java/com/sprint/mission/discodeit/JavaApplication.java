package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;
import com.sprint.mission.discodeit.service.jcf.JCFChannelService;
import com.sprint.mission.discodeit.service.jcf.JCFMessageService;
import com.sprint.mission.discodeit.service.jcf.JCFUserService;

import java.util.NoSuchElementException;

public class JavaApplication {
    public static void main(String[] args) {
//        User user = new User("hyunseok", "hyunseok@example.com", "1234");
//        System.out.println("수정 전 : " + user);
//
//        user.updata("hyunseok2", null, null);
//        System.out.println("수정 후: " + user);


//        Channel channel = new Channel("우리 소통해요~~", "편하게 떠들 수 있는 공간입니다.");
//        System.out.println("수정 전 : " + channel);
//
//        channel.update("우리 토론해요~!", "상대방을 존중하며 토론합시다.");
//        System.out.println("수정 후 : " + channel);

//        Message message = new Message("안녕하세요~!", channel.getId(), user.getId());
//        System.out.println("수정 전 : " + message);
//
//        message.update("반갑습니다~!!");
//        System.out.println("수정 후 : " + message);

        UserService userService = new JCFUserService();
//
        User user1 = userService.create("hyunseok", "hyunseok@example.com", "1234");
//        User user2 = userService.create("codeit", "codeit@example.com", "5678");
//
//        userService.update(user1.getId(), "hyunseok2", null, null);
//        System.out.println("수정 후 조회: " + userService.find(user1.getId()));
//
//        userService.delete(user2.getId());
//        System.out.println("삭제 후 전체 수: " + userService.findAll().size());
//
//        try {
//            userService.find(user2.getId());
//        } catch (NoSuchElementException e) {
//            System.out.println("삭제확인 : " + e.getMessage());
//        }

//        System.out.println("전체 조회 수: " + userService.findAll().size());
//        System.out.println("전체 조회: " + userService.findAll());
//        System.out.println("단건 조회: " + userService.find(user1.getId()));

        ChannelService channelService = new JCFChannelService();

        Channel channel1 = channelService.create("일반", "자유롭게 이야기하는 곳");
        Channel channel2 = channelService.create("게임방", "재밌게 게임하는 곳");

        channelService.update(channel1.getId(), "잡담", null);
        System.out.println("채널 수정 후 조회: " + channelService.find(channel1.getId()));

        channelService.delete(channel2.getId());
        System.out.println("채널 삭제 후 전체 수: " + channelService.findAll().size());

//        try {
//            channelService.find(channel2.getId());
//        } catch (NoSuchElementException e) {
//            System.out.println("채널 삭제 확인: " + e.getMessage());
//        }

        MessageService messageService = new JCFMessageService();
        Message message1 = messageService.create("안녕하세요", channel1.getId(), user1.getId());
        Message message2 = messageService.create("반갑습니다", channel1.getId(), user1.getId());

        System.out.println("메시지 전체 수: " + messageService.findAll().size());
        System.out.println("메시지 전체 조회: " + messageService.findAll());
        System.out.println("메시지 단건 조회: " + messageService.find(message1.getId()));
    }
}