package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.User;

public class JavaApplication {
    public static void main(String[] args) {
        User user = new User("hyunseok", "hyunseok@example.com", "1234");
        System.out.println("수정 전 : " + user);

        user.updata("hyunseok2", null, null);
        System.out.println("수정 후: " + user);
    }
}