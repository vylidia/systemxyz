package example.test.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "statistic")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idCourse;

    private String courseName;

    private Long idThema;

    private String themaName;

    private Long idUser;

    private String username;

    private Long idTeacher;

    private Date date;

    private int result;

    public Long getId() {
        return id;
    }

    public Long getIdCourse() {
        return idCourse;
    }

    public Long getIdThema() {
        return idThema;
    }

    public Long getIdUser() {
        return idUser;
    }

    public Date getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public void setIdThema(Long idThema) {
        this.idThema = idThema;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Long idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getThemaName() {
        return themaName;
    }

    public String getUsername() {
        return username;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setThemaName(String themaName) {
        this.themaName = themaName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void fill(Long idCourse, String courseName, Long idThema, String themaName, String username, Date date, int result) {
        this.setIdCourse(idCourse);
        this.setCourseName(courseName);
        this.setIdThema(idThema);
        this.setThemaName(themaName);
        this.setUsername(username);
        this.setDate(date);
        this.setResult(result);
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", idCourse=" + idCourse +
                ", idThema=" + idThema +
                ", idUser=" + idUser +
                ", date=" + date +
                '}';
    }
}
