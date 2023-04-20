package br.com.person.project.student;

import br.com.person.project.course.CourseEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String dept;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "STUDENT_COURSE_TABLE",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<CourseEntity> courseEntitySet = new HashSet<>();

    public StudentEntity() {
    }

    public StudentEntity(Long id, String name, int age, String dept, Set<CourseEntity> courseEntitySet) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.courseEntitySet = courseEntitySet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Set<CourseEntity> getCourseEntitySet() {
        return courseEntitySet;
    }

    public void setCourseEntitySet(Set<CourseEntity> courseEntitySet) {
        this.courseEntitySet = courseEntitySet;
    }
}
