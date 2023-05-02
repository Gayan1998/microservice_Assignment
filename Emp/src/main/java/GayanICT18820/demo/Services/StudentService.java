package GayanICT18820.demo.Services;

import GayanICT18820.demo.entity.EmployeeEntity;
import GayanICT18820.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeEntity AddNewStudent(EmployeeEntity student) {
        return employeeRepository.save(student);
    }

    public List<EmployeeEntity> GetAll() {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeEntity> FindStudentById(Long id) {
        return employeeRepository.findById(id);
    }
    public List<EmployeeEntity> findByName(String name) {
        return employeeRepository.findByName(name);
    }
    public EmployeeEntity UpdateStudentById(Long id, EmployeeEntity updatedStudent) {
        return employeeRepository.findById(id)
                .map(student -> {
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setLastName(updatedStudent.getLastName());
                    return employeeRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student with ID " + id + " not found"));
    }

    public void DeleteStudentById(Long id) {employeeRepository.deleteById(id);
    }
}
