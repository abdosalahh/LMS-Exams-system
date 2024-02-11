public class Choice {
    int id;
    String content;
    boolean status;
    /*
        All Choices Must Have Status False Except One Choice Must have Status True
        Any Question Must Contains four Choices Only
    */

    public Choice(int id, String content, boolean status) {
        this.id = id;
        this.content = content;
        this.status = status;
    }
}
