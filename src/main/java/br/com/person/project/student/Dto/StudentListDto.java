package br.com.person.project.student.Dto;

import br.com.person.project.course.CourseEntity;
import br.com.person.project.student.StudentEntity;

import java.util.HashSet;
import java.util.Set;

public class StudentListDto {

    private Long id;

    private String name;

    private int age;

    private String dept;

    private Set<CourseEntity> courseEntitySet =  new HashSet<>();

    public StudentListDto() {
    }

    public StudentListDto(StudentEntity student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
        this.dept = student.getDept();
        this.courseEntitySet = student.getCourseEntitySet();
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
