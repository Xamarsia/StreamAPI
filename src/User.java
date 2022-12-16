public class User {

    private UserDto userDto;
    private float height = 0;
    private String group = "";
    private String password = "";

    public User(String name, int age, float height, String group, String password, String email)
            throws IllegalArgumentException {
        userDto = new UserDto(name, age, email);

        this.setHeight(height);
        this.setGroup(group);
        this.setPassword(password);
    }

    public User(UserDto userDto, float height, String group, String password)
            throws IllegalArgumentException {
        this.userDto = userDto;
        this.setHeight(height);
        this.setGroup(group);
        this.setPassword(password);
    }

    public User(String name, int age, String email) throws IllegalArgumentException {
        userDto = new UserDto(name, age, email);
    }

    public User(UserDto userDto) throws IllegalArgumentException {
        this.userDto = userDto;
    }

    public String getName() {
        return userDto.getName();
    }

    public void setName(String name) {
        userDto.setName(name);
    }

    public int getAge() {
        return userDto.getAge();
    }

    public void setAge(int age) {
        userDto.setAge(age);
    }

    public String getEmail() {
        return userDto.getEmail();
    }

    public void setEmail(String email) {
        userDto.setEmail(email);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) throws IllegalArgumentException {
        if (height < 0) {
            throw new IllegalArgumentException("height must be non-negative");
        } else if (height >= 300) {
            throw new IllegalArgumentException("height incorrect");
        }

        this.height = height;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws IllegalArgumentException {
        if (password.isEmpty()) {
            throw new IllegalArgumentException("password must be non-empty");
        }
        this.password = password;
    }
}
