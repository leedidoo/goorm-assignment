package com.example.student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.api.Status;
import com.example.api.ErrorData;
import com.example.api.Metadata;
import com.example.api.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    // 이름과 성적을 입력받아 저장하는 API
    @PostMapping("/add")
    public Response<Student> addStudent(@RequestBody Student student) {
        if (student.getGrade() > 7) {
            throw new IllegalArgumentException("grade는 6 이상을 입력할 수 없습니다.");
        }
        students.add(student);
        return new Response<>(new Status(2000, "OK"), null, List.of(student));
    }

    // 입력된 성적을 조회하는 API (성적은 오름차순으로 조회)
    @GetMapping("/all")
    public Response<Student> getAllStudents() {
        List<Student> sortedStudents = students.stream()
                .sorted(Comparator.comparingInt(Student::getGrade))
                .collect(Collectors.toList());

        return new Response<>(new Status(2000, "OK"), new Metadata(sortedStudents.size()), sortedStudents);
    }

    // 특정 성적을 입력받아 해당 성적의 학생만 조회하는 API
    @GetMapping("/grade/{grade}")
    public Response<Student> getStudentsByGrade(@PathVariable int grade) {
        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getGrade() == grade)
                .collect(Collectors.toList());

        if (filteredStudents.isEmpty()) {
            return new Response<>(new Status(HttpStatus.NOT_FOUND.value(), "No students found with grade " + grade), null, null);
        }

        return new Response<>(new Status(2000, "OK"), new Metadata(filteredStudents.size()), filteredStudents);
    }

    // 에러 응답을 처리하는 핸들러
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<ErrorData> handleException(IllegalArgumentException ex) {
        return new Response<>(new Status(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()), null,
                List.of(new ErrorData("grade는 6 이상을 입력할 수 없습니다.", 6)));
    }
}