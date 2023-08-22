package com.krishna.springboot.controller;

import com.krishna.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students") // base URL handles students
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "krishna",
                "gedda"
        );
//        return new ResponseEntity<>(student, HttpStatus.OK);
//        return ResponseEntity.ok(student);

        return ResponseEntity.ok().header("custom-header", "krishna")
                .body(student);
    }

    // http://localhost:8080/students

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<Student>();

        students.add(new Student(1, "krishna", "sai"));
        students.add(new Student(2, "somesh", "rao"));
        students.add(new Student(3, "srinu", "john"));
        students.add(new Student(4, "jackie", "chan"));


        return ResponseEntity.ok(students);
    }

    // Spring BOOT REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/1/krishna/gedda
    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        Student student = new Student(studentId, firstName , lastName);

        return ResponseEntity.ok(student);
    }

    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=krishna&lastName=gedda
    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        Student student =  new Student(id, firstName, lastName );

        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handles HTTP POST Request
    // @PostMapping and @RequestBody

    // http://localhost:8080/students/create
    @PostMapping("/create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring boot REST API that handle HTTP PUT Request - updating existing resource
    // http://localhost:8080/students/2/update
    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handles HTTP DELETE Request - deleting the existing resource
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }

}
