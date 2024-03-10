package org.training.samples.functions;

import lombok.Data;

import java.util.UUID;

public class OutputParam {
    public static void main(String[] args) {
        User user = new User();
        createUserId(user);
        System.out.println(user);
    }

    // ?? create??
    private static void createUserId(User user) {
        user.setId(UUID.randomUUID());
    }

}

@Data
class User {
    private UUID id;
    private String name;
}
