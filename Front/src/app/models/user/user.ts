export interface UserType {
    id: number,
    email: string,
    username: string,
    password: string,
    role: number
}

export function createUser(partial: Partial<UserType> = {}): UserType {
    return {
        id: -1,
        email: "test@test.com",
        username: "User 1",
        password: "MonP@5sW0rd1234",
        role: 0,
        ...partial, // surcharge les valeurs par défaut
    };
}

//const u2 = createRound({ name: "Alice" });