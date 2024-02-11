public class LoginFactory {
    public User getUesr(String authority){
        if (authority==null){
            return null;
        }
        else if (authority.equalsIgnoreCase("principle"))
        {
            return new Principle();
        }
        else if (authority.equalsIgnoreCase("teacher"))
        {
            return new Teacher();
        }
        else if (authority.equalsIgnoreCase("student"))
        {
            return new Student();
        }
    return null;
    }
}
