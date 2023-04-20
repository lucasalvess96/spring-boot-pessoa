package br.com.person.project.student;

import br.com.person.project.cart.Dto.CartDto;
import br.com.person.project.student.Dto.StudentCreateDto;
import br.com.person.project.student.Dto.StudentListDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<StudentCreateDto>create(@RequestBody @Valid StudentCreateDto studentCreateDto) {
        StudentCreateDto studentCreateDto1 = studentService.studentCreateDto(studentCreateDto);

        if(studentCreateDto1 != null) return new ResponseEntity<>(studentCreateDto1, HttpStatus.CREATED);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<Page<StudentListDto>> list(@PageableDefault(direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.studentList(pageable));
    }
}
