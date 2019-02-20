package com.mastery.java.task.dao;

    import java.util.List;
    import com.mastery.java.task.dto.Employee;
    import com.mastery.java.task.dao.EmployeeRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

@Service
public class EmployeeDAO {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeDAO(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long userId, Employee employee) {
        employee.setemployee_id(userId);
        return employeeRepository.save(employee);
    }

    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    public void deleteById(Long userId) {
        employeeRepository.deleteById(userId);
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Long userId) {
        return employeeRepository.findById(userId).orElse(null);
    }

    public void firstInit(){
        Employee employee = new Employee ();
        employee.setemployee_id ((long) 1);
        employee.setfirst_name ("Bilbo");
        employee.setlast_name ("Baggins");
        employee.setdepartment_id ("hobbits");
        employee.setjob_title ("Hobbit");
        employee.setgender ("MALE");
        employee.setdate_of_birth ("2890");
        createEmployee(employee);

        employee.setemployee_id ((long) 2);
        employee.setfirst_name ("Thorin");
        employee.setlast_name ("Oakenshield");
        employee.setdepartment_id ("dwarfs");
        employee.setjob_title ("Dwarf");
        employee.setgender ("MALE");
        employee.setdate_of_birth ("2746");
        createEmployee(employee);

        employee.setemployee_id ((long) 3);
        employee.setfirst_name ("Arwen");
        employee.setlast_name ("UndГіmiel");
        employee.setdepartment_id ("elven");
        employee.setjob_title ("Half-elven");
        employee.setgender ("FEMALE");
        employee.setdate_of_birth ("241");
        createEmployee(employee);
    }
}
