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
        UserService userService = new JCFUserService();
        ChannelService channelService = new JCFChannelService();
        MessageService messageService = new JCFMessageService();

        userTest(userService);
        channelTest(channelService);
        messageTest(messageService, userService, channelService);
    }

    private static void userTest(UserService userService) {
        System.out.println("========== User 테스트 ==========");

        System.out.println("[User] 1.등록");
        User user1 = userService.create("hyunseok", "hyunseok@example.com", "1234");
        User user2 = userService.create("codeit", "codeit@example.com", "5678");
        System.out.println("등록: " + user1);
        System.out.println("등록: " + user2);

        System.out.println("[User] 2.조회");
        System.out.println("단건: " + userService.find(user1.getId()));
        System.out.println("다건(" + userService.findAll().size() + "명): " + userService.findAll());

        System.out.println("[User] 3.수정");
        userService.update(user1.getId(), "hyunseok2", null, null);

        System.out.println("[User] 4.수정 조회");
        System.out.println("수정 결과: " + userService.find(user1.getId()));

        System.out.println("[User] 5.삭제");
        userService.delete(user2.getId());

        System.out.println("[User] 6.삭제 확인");
        System.out.println("남은 수: " + userService.findAll().size());
        try {
            userService.find(user2.getId());
        } catch (NoSuchElementException e) {
            System.out.println("삭제됨: " + e.getMessage());
        }
        System.out.println();
    }

    private static void channelTest(ChannelService channelService) {
        System.out.println("========== Channel 테스트 ==========");

        System.out.println("[Channel] 1.등록");
        Channel channel1 = channelService.create("일반", "자유롭게 이야기하는 곳");
        Channel channel2 = channelService.create("공지", "공지사항 채널");
        System.out.println("등록: " + channel1);
        System.out.println("등록: " + channel2);

        System.out.println("[Channel] 2.조회");
        System.out.println("단건: " + channelService.find(channel1.getId()));
        System.out.println("다건(" + channelService.findAll().size() + "개): " + channelService.findAll());

        System.out.println("[Channel] 3.수정");
        channelService.update(channel1.getId(), "잡담", null);

        System.out.println("[Channel] 4.수정 조회");
        System.out.println("수정 결과: " + channelService.find(channel1.getId()));

        System.out.println("[Channel] 5.삭제");
        channelService.delete(channel2.getId());

        System.out.println("[Channel] 6.삭제 확인");
        System.out.println("남은 수: " + channelService.findAll().size());
        try {
            channelService.find(channel2.getId());
        } catch (NoSuchElementException e) {
            System.out.println("삭제됨: " + e.getMessage());
        }
        System.out.println();
    }

    private static void messageTest(MessageService messageService,
                                    UserService userService,
                                    ChannelService channelService) {
        System.out.println("========== Message 테스트 ==========");

        // 메시지에 필요한 작성자와 채널 준비
        User author = userService.create("writer", "writer@example.com", "0000");
        Channel channel = channelService.create("질문", "질문하는 채널");

        System.out.println("[Message] 1.등록");
        Message message1 = messageService.create("안녕하세요", channel.getId(), author.getId());
        Message message2 = messageService.create("반갑습니다", channel.getId(), author.getId());
        System.out.println("등록: " + message1);
        System.out.println("등록: " + message2);

        System.out.println("[Message] 2.조회");
        System.out.println("단건: " + messageService.find(message1.getId()));
        System.out.println("다건(" + messageService.findAll().size() + "개): " + messageService.findAll());

        System.out.println("[Message] 3.수정");
        messageService.update(message1.getId(), "안녕하세요! 수정된 메시지입니다");

        System.out.println("[Message] 4.수정 조회");
        System.out.println("수정 결과: " + messageService.find(message1.getId()));

        System.out.println("[Message] 5.삭제");
        messageService.delete(message2.getId());

        System.out.println("[Message] 6.삭제 확인");
        System.out.println("남은 수: " + messageService.findAll().size());
        try {
            messageService.find(message2.getId());
        } catch (NoSuchElementException e) {
            System.out.println("삭제됨: " + e.getMessage());
        }
    }
}