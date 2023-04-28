package br.com.person.project.student;

import br.com.person.project.cart.CartEntity;
import br.com.person.project.cart.Dto.CartDto;
import br.com.person.project.course.CourseEntity;
import br.com.person.project.course.CourseRepository;
import br.com.person.project.items.Items;
import br.com.person.project.student.Dto.StudentCreateDto;
import br.com.person.project.student.Dto.StudentListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public StudentCreateDto studentCreateDto(StudentCreateDto studentCreateDto) {
        StudentEntity student = new StudentEntity();
        student.setName(studentCreateDto.getName());
        student.setAge(studentCreateDto.getAge());
        student.setDept(studentCreateDto.getDept());
        student.setCourseEntitySet(studentCreateDto.getCourseEntitySet());
        return new StudentCreateDto(studentRepository.save(student));
    }

    public Page<StudentListDto> studentList(Pageable pageable) {
        Page<StudentEntity> studentEntityPagE = studentRepository.findAll(pageable);
        return studentEntityPagE.map(StudentListDto::new);
    }
}
