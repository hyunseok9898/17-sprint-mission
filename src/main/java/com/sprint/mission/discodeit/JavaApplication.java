package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.User;

public class JavaApplication {
    public static void main(String[] args) {
//        User user = new User("hyunseok", "hyunseok@example.com", "1234");
//        System.out.println("수정 전 : " + user);
//
//        user.updata("hyunseok2", null, null);
//        System.out.println("수정 후: " + user);
        Channel channel = new Channel("우리 소통해요~~", "편하게 떠들 수 있는 공간입니다.");
        System.out.println("수정 전 : " + channel);

        channel.update("우리 토론해요~!", "상대방을 존중하며 토론합시다.");
        System.out.println("수정 후 : " + channel);
    }
}