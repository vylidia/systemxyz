package example.test.model;

import javax.persistence.*;

@Entity
@Table(name = "thema")
public class Thema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String thema;

    private String themaName;

    private Long idCourse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getThemaName() {
        return themaName;
    }

    public void setThemaName(String themaName) {
        this.themaName = themaName;
    }

    @Override
    public String toString() {
        return "Thema{" +
                "id=" + id +
                ", thema='" + thema + '\'' +
                ", themaName='" + themaName + '\'' +
                ", idCourse=" + idCourse +
                '}';
    }
}
