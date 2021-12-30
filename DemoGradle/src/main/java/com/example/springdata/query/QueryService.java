package com.example.springdata.query;

import com.example.springdata.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class QueryService {


    @Autowired
    EmployeeRepository employeeRepository;


    @Autowired
    PhoneRepository phoneRepository;

    @Autowired
    DepartmentRepository departmentRepository;


    //https://www.baeldung.com/hibernate-entitymanager
    @PersistenceContext // or even @Autowired
    private EntityManager entityManager;


    /*

mysql> select e.name, e.age,d.name  from employee e, department d where d.id=e.department_id ;
+--------+-----+----------+
| name   | age | name     |
+--------+-----+----------+
| Anoop  |  30 | HR       |
| Kamal  |  31 | IT       |
| Simran |  40 | IT       |
| Kiran  |  30 | IT       |
| Lalit  |  30 | ACCOUNTS |
| Raman  |  50 | ACCOUNTS |
+--------+-----+----------+
6 rows in set (0.00 sec)

       */
    public List<?> getEmployeeList(){
        List<?> list= entityManager.createQuery(" select e.name, e.age,d.name ,ph.number from Employee e, Department d,Phone ph where d.id=e.department.id and ph.employee.id=e.id").getResultList();

        return list;
    }


    @Transactional
    public void saveEmployees(List<EmployeeDTO> employeeDTOList){
      for(EmployeeDTO employeeDTO:employeeDTOList){
          Employee emp=new Employee();
          emp.setAge(Integer.parseInt(employeeDTO.getAge()));
          emp.setName(employeeDTO.getName());
          Department d=departmentRepository.findDepartmentById(Long.parseLong(employeeDTO.getDepartmentId()));
          emp.setDepartment(d);
          emp=employeeRepository.save(emp);
          Phone ph=new Phone();
          ph.setEmployee(emp);
          ph.setNumber(employeeDTO.getPhoneNumber());
          phoneRepository.save(ph);
      }

    }
}
