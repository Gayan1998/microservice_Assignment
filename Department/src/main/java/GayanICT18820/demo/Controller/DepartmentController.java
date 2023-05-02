package GayanICT18820.demo.Controller;

import GayanICT18820.demo.Services.DepartmentService;
import GayanICT18820.demo.entity.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class DepartmentController {
    @Autowired
    private DepartmentService DepartmentService;

    @PostMapping
    public DepartmentEntity create(@RequestBody DepartmentEntity department) {
        return DepartmentService.AddNewStudent(department);
    }
    @GetMapping
    public List<DepartmentEntity> findAll() {
        return DepartmentService.GetAll();
    }

    @GetMapping("/{id}")
    public Optional<DepartmentEntity> findById(@PathVariable Long id) {
        return DepartmentService.FindStudentById(id);
    }

    @PutMapping("/{id}")
    public DepartmentEntity updateStudent(@PathVariable Long id, @RequestBody DepartmentEntity updatedStudent) {
        return DepartmentService.UpdateStudentById(id, updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        DepartmentService.DeleteStudentById(id);
    }

    @GetMapping("/search")
    public List<DepartmentEntity> findByName(@RequestParam("name") String name) {
        return DepartmentService.findByName(name);
    }
}
