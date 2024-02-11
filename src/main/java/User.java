public abstract class User {
    int id;
    String name;
    String email;
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(long phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    long Phone_Number;
    String Type;
    public User() {
    }

    public User(int id, String name, String email, String password, long phone_Number, String type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        Phone_Number = phone_Number;
        Type = type;
    }
    public abstract boolean Login(String enteredEmail, String enteredPassword);
}
