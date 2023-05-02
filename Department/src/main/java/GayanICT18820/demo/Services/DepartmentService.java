package GayanICT18820.demo.Services;

import GayanICT18820.demo.entity.DepartmentEntity;
import GayanICT18820.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentEntity AddNewStudent(DepartmentEntity student) {
        return departmentRepository.save(student);
    }

    public List<DepartmentEntity> GetAll() {
        return departmentRepository.findAll();
    }

    public Optional<DepartmentEntity> FindStudentById(Long id) {
        return departmentRepository.findById(id);
    }
    public List<DepartmentEntity> findByName(String name) {
        return departmentRepository.findByName(name);
    }
    public DepartmentEntity UpdateStudentById(Long id, DepartmentEntity updatedStudent) {
        return departmentRepository.findById(id)
                .map(student -> {
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setLastName(updatedStudent.getLastName());
                    return departmentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student with ID " + id + " not found"));
    }

    public void DeleteStudentById(Long id) {
        departmentRepository.deleteById(id);
    }
}
