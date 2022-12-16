public class UserDto {
    private String name;
    private int age;
    private String email;

    public UserDto(String name, int age, String email) throws IllegalArgumentException {
        this.setName(name);
        this.setAge(age);
        this.setEmail(email);
    }

    public UserDto(UserDto userDto) throws IllegalArgumentException {
        this.setName(userDto.getName());
        this.setAge(userDto.getAge());
        this.setEmail(userDto.getEmail());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name must be non-empty");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("age must be non-negative");
        } else if (age > 150) {
            throw new IllegalArgumentException("age incorrect");
        }
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if (!email.contains("@") || email.length() < 4) {
            throw new IllegalArgumentException("email incorrect");
        }
        this.email = email;
    }
}
