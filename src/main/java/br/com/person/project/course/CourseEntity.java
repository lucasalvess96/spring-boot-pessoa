package br.com.person.project.course;

import br.com.person.project.student.StudentEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String abbreviation;

    private int modules;

    private double fee;

    @ManyToMany(mappedBy = "courseEntitySet", fetch = FetchType.LAZY)
    private Set<StudentEntity> studentEntities;

    public CourseEntity() {
    }

    public CourseEntity(Long id, String title, String abbreviation, int modules, double fee, Set<StudentEntity> studentEntities) {
        this.id = id;
        this.title = title;
        this.abbreviation = abbreviation;
        this.modules = modules;
        this.fee = fee;
        this.studentEntities = studentEntities;
    }
}
