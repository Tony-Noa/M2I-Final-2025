export interface UserDto {

    email: string,
    username: string,
    password: string,
    role: number
}

export function createUserDto(partial: Partial<UserDto> = {}): UserDto {
    return {
        email: "test@test.com",
        username: "User 1",
        password: "MonP@5sW0rd1234",
        role: 0,
        ...partial, // surcharge les valeurs par défaut
    };
}