import java.util.Arrays;
import java.util.List;

public class principleProxy implements urlProvider {
    private List<String> principleBlockedUrl = Arrays.asList("html/student.jsp", "html/teacher.jsp");

    @Override
    public String serverSite(String url) {
        if (principleBlockedUrl.contains(url)) {
            return null;
        }
        else {
            return url;
        }
    }

}