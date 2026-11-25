package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.User;

public class JavaApplication {
    public static void main(String[] args) {
        User user = new User("hyunseok", "hyunseok@example.com", "1234");
        System.out.println(user);
    }
}