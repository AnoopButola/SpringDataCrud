package com.example.springdata.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.springdata.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.accessingdatamysql.User;
import com.example.accessingdatamysql.UserRepository;
import com.example.springdata.dto.JsonDTO;

import io.swagger.annotations.Api;

/*
 * https://www.baeldung.com/spring-data-jpa-query
 * 
 * 
 * https://www.baeldung.com/jpa-join-types  Entities  prepared from here 
 * 
 * 
 */

@RestController
@Api(value="QueryController", description="Use it for select using joins/criteria/sp/view etc")
@RequestMapping(value="/query")
public class QueryController {

	@Autowired
	 private UserRepository userRepository;
	
	
	@Autowired 
	DepartmentRepository departmentRepository;
	
	@Autowired
	EmployeeRepository  employeeRepository;
	
	@Autowired
	PhoneRepository  phoneRepository;


	@Autowired
	QueryService queryService;
	
	//@ApiOperation(value = "View a list of all non admin users", response = Collection.class)
	@GetMapping("/users")
	public Collection<User> listUsersByRole(){
		return userRepository.findNonAdminUsers();
	}
	
	
	@PostMapping(value="/employee")
	public String saveEmployee(){
		//persist 10 employee 
		for(int i=1;i<=10;i++){
		Employee emp=	new Employee();
		emp.setAge(40+i);
		emp.setName("Anoop"+i);
		emp.setDepartment(departmentRepository.findDepartmentById(74+i));
		employeeRepository.save(emp);
		
		}

		//perisit phone number of each employee
		for(int i=1;i<=3;i++){
		Long id=Long.valueOf(i+2);
		Employee emp1=employeeRepository.findById(id).isPresent()?employeeRepository.findById(id).get():null;
			if(null!=emp1){
				for(int j=1;j<=3;j++){
					Phone ph=new Phone();
					ph.setNumber("783721820"+i);
					ph.setEmployee(emp1);
					phoneRepository.save(ph);
				}	
			}
			
		}
		
		
		
		return "EMPLOYEES AND DEPT SAVED";
	}
	
	
	@PostMapping(value="/department")
	public String createDepartment(){
	 //perisist 13 dept for query purpose
		for(int i=1;i<13;i++){
			String deptName="IT";
			if(i%2==0){
				deptName="HR";
			}
			
			if(i%3==0){
				deptName="Accounts";
			}
			
			Department dept1=new Department(deptName);
			departmentRepository.save(dept1);
		}
	
		return "Department SAVED";
	}
	
	
	@GetMapping(value="/getAllEmployess")
	public List<Employee> getAllEmployess(){
		return StreamSupport.stream(employeeRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@GetMapping(value="/getAllPhoneNumbers")
	public ResponseEntity getAllPhoneNumber(){
		GenericResponse reBody=null;
		try{

			List<Phone> list=new ArrayList<Phone>();
			Iterable<Phone> itr=phoneRepository.findAll();
	        // Use iterable.forEach() to 
	        // Iterate through the iterable and 
	        // add each element into the collection 
	        itr.forEach(list::add);
	    	 reBody=new GenericResponse("Get Success", "200", list);
	    	
		} catch(Exception e){
	         reBody.setResponseCode("200");
	         reBody.setResponseMsg("Error occurred while processing request");
			 return ResponseEntity.ok(reBody);
		}
	
		return ResponseEntity.ok(reBody);
	}
	
	/*@GetMapping(value="/getAllDepartments")
	public GenericResponse getAllDepartments(){
		List<Department> deptlist=new ArrayList<Department>();
      //  return departmentRepository.findAll()!=null?departmentRepository.findAll().forEach(deptlist::add):null;
	}
	*/
	
	
	@GetMapping(value="getJSONViewOfPOJO")
	public JsonDTO returnSimpleJsonDTO(){
	JsonDTO jsonDTO=	new JsonDTO();
	jsonDTO.setAddress("London");
	//jsonDTO.setJsonMainWrapper(null);
	jsonDTO.setName("Test");
	jsonDTO.setSalary(45000.00);
	jsonDTO.setIndex(100);
	return jsonDTO;
	}
	
	
	
	
	@GetMapping(value="getJSONList")
	public List<JsonDTO> returnJSONList(){
	List<JsonDTO> list=	new ArrayList<JsonDTO>();
	for(int i=1;i<5;i++){
		JsonDTO jsonDTO=	new JsonDTO();
		jsonDTO.setAddress("London");
		jsonDTO.setName("Test");
		jsonDTO.setSalary(45000.00);
		jsonDTO.setIndex(100);
		list.add(jsonDTO);
	}
	return list;
	
	}
	

	@GetMapping(value="/employees")
	public List<?> employeeList(){
       return queryService.getEmployeeList();
	}


	@PostMapping(value="/employees")
	public String saveEmployees(@RequestBody List<EmployeeDTO> employeeDTOList){
         //System.out.println(List<EmployeeDTO>.toString());
		queryService.saveEmployees(employeeDTOList);
		return "Employees saved successfully";
	}
	
	
	
}
