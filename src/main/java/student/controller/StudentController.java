package student.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import student.Service.StudentServicelmpl;
import student.object.Student;
import student.object.StudentCdo;

@RestController
@Getter
@Setter
public class StudentController {
    private StudentServicelmpl studentServicelmpl;
    public StudentController(StudentServicelmpl studentServicelmpl){
        this.studentServicelmpl=studentServicelmpl;
    }

    @PostMapping("/test")
    public void insert(@RequestBody StudentCdo studentCdo){
        studentServicelmpl.insert(studentCdo);
    }
    @GetMapping("/test")
    public StudentCdo findId(@RequestParam Long id){
        return studentServicelmpl.retriveService(id).toCdo();
    }
    @PutMapping("/test")
    public void modify(@RequestParam Long id, @RequestBody StudentCdo studentCdo){
        studentServicelmpl.modify(id, studentCdo);
    }
    @DeleteMapping("/test")
    public void delete(@RequestParam Long id){
        studentServicelmpl.delete(id);
    }

}
