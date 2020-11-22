package example.test.model;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer taskName;

    private String taskText;

    private String taskPattern;

    private Long idThema;

    private String answer;

    private String solve;

    public Long getId() {
        return id;
    }

    public Integer getTaskName() {
        return taskName;
    }

    public String getTaskText() {
        return taskText;
    }

    public String getTaskPattern() {
        return taskPattern;
    }

    public Long getIdThema() {
        return idThema;
    }

    public String getAnswer() {
        return answer;
    }

    public String getSolve() {
        return solve;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTaskName(Integer taskName) {
        this.taskName = taskName;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public void setTaskPattern(String taskPattern) {
        this.taskPattern = taskPattern;
    }

    public void setIdThema(Long idThema) {
        this.idThema = idThema;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setSolve(String solve) {
        this.solve = solve;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskText='" + taskText + '\'' +
                ", taskPattern='" + taskPattern + '\'' +
                ", idThema=" + idThema +
                ", answer='" + answer + '\'' +
                ", solve='" + solve + '\'' +
                '}';
    }
}
