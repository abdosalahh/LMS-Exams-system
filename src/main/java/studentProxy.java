import java.util.Arrays;
import java.util.List;

public class studentProxy implements urlProvider {
    private List<String> studentBlockedUrl = Arrays.asList("html/teacher.jsp", "html/principle.jsp");

    @Override
    public String serverSite(String url) {
        if (studentBlockedUrl.contains(url)) {
            return null;
        }
        else {
            return url;
        }
    }

}