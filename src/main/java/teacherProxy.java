import java.util.Arrays;
import java.util.List;

public class teacherProxy implements urlProvider{
    private List<String> teacherBlockedUrl = Arrays.asList("html/student.jsp", "html/principle.jsp");
    @Override
    public String serverSite(String url) {
        if (teacherBlockedUrl.contains(url)) {
            return null;
        } else {
            return url;
        }
    }
}