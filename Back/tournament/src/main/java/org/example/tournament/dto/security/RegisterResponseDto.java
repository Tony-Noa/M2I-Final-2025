package org.example.tournament.dto.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tournament.entity.UserAccount;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponseDto {
    private int id;
    private String email;
    private String username;
    private String pp;
    private int role;

    public static RegisterResponseDto entityToDto(UserAccount userAccount) {
        return RegisterResponseDto.builder()
                .id(userAccount.getUserAccountId())
                .email(userAccount.getEmail())
                .username(userAccount.getUsername())
                .pp(userAccount.getPp())
                .role(userAccount.getRole().ordinal())
                .build();
    }

}
