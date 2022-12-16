public class UserMapper {

    static public User mapToUser(UserDto userDto) {
        return new User(userDto);
    }

    static public UserDto mapToDto(User user) {
        UserDto userDto = new UserDto(
                user.getName(), user.getAge(), user.getEmail());
        return userDto;
    }
}
