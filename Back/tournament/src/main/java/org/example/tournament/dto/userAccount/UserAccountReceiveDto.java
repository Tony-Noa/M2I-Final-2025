package org.example.tournament.dto.userAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.entity.UserAccount;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserAccountReceiveDto {

    private String username;
    private String password;
    private String pp; // Profile picture

    public UserAccount dtoToEntity() {
        return UserAccount.builder()
                .username(getUsername())
                .password(getPassword())
                .pp(getPp())
                .build();
    }

}
