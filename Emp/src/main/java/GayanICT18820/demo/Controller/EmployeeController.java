package GayanICT18820.demo.Controller;

import GayanICT18820.demo.Services.StudentService;
import GayanICT18820.demo.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class EmployeeController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public EmployeeEntity create(@RequestBody EmployeeEntity student) {
        return studentService.AddNewStudent(student);
    }
    @GetMapping
    public List<EmployeeEntity> findAll() {
        return studentService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeEntity> findById(@PathVariable Long id) {
        return studentService.FindStudentById(id);
    }

    @PutMapping("/{id}")
    public EmployeeEntity updateStudent(@PathVariable Long id, @RequestBody EmployeeEntity updatedStudent) {
        return studentService.UpdateStudentById(id, updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.DeleteStudentById(id);
    }

    @GetMapping("/search")
    public List<EmployeeEntity> findByName(@RequestParam("name") String name) {
        return studentService.findByName(name);
    }
}
