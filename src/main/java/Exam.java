
import java.time.LocalDateTime;
public class Exam {
    int id;
    boolean conducted;
    String name;
    String type;
    LocalDateTime StartTime;
    LocalDateTime EndTime;
    double TotalGrade;
    int level;
    public Exam(){
        super();
    }
    public Exam(int id, boolean conducted, String name, String type, LocalDateTime startTime, LocalDateTime endTime, double totalGrade , int level) {
        this.id = id;
        this.conducted = conducted;
        this.name = name;
        this.type = type;
        StartTime = startTime;
        EndTime = endTime;
        TotalGrade = totalGrade;
        this.level =level;
    }

}