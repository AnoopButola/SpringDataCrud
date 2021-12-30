package com.example.dbscript.init;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DbPersistService {
    @Autowired
    private PasswordEncoder bcryptEncoder;
    // bcryptEncoder.encode("password"+i)
    @Autowired
    JdbcTemplate jdbcTemplate;

    List<Object[]> roleDataDefault = Arrays.asList("1 role_is_admin ADMIN", "2 role_is_normal_user USER").stream().map(name -> name.split(" ")).collect(Collectors.toList());

    List<Object[]> userDataDefault = Arrays.asList("1 admin@gmail.com admin password admin 1", "2 user1@gmail.com user1 password user1 2", "3 user2@gmail.com user2 password user2 2").stream().map(name -> name.split(" ")).collect(Collectors.toList());

    List<Object[]> departmentDataDefault = Arrays.asList("1 HR", "2 IT", "3 ACCOUNTS").stream().map(name -> name.split(" ")).collect(Collectors.toList());

    List<Object[]> employeeDataDefault = Arrays.asList("1 30 Anoop 1", "2 31 Kamal 2", "3 30 Lalit 3", "4 40 Simran 2", "5 50 Raman 3", "6 30 Kiran 2").stream().map(name -> name.split(" ")).collect(Collectors.toList());

    List<Object[]> phoneDataDefault = Arrays.asList("1 7837218200 1", "2 8989234567 2", "3 8989373838 3", "4 8723434345 4", "5 9898342334 5").stream().map(name -> name.split(" ")).collect(Collectors.toList());

    // private static final  String INSERT_DEFAULT_ROLES ="insert into role values (1,'ADMIN',1);";
    //private static final  String INSERT_DEFAULT_USER ="insert into user values(1,'user1@gmail.com','user1','password1','user1',1);";


     //This method will be only exposed as all other methods are internal to this class.
    public void initAllTables() {
        initDefaultRoleAndUserTable();
        initDefaultDepartmentAndEmployeeTable();
        initDefaultPhoneTable();
    }

    private void initDefaultRoleAndUserTable() {
        jdbcTemplate.batchUpdate("INSERT INTO role(id, description,role_name) VALUES (?,?,?)", roleDataDefault);
        //decrrypt password frist and then save
        for (Object[] objects : userDataDefault) {
            String password = (String) objects[3];
            String encryptedPass = bcryptEncoder.encode(password);
            objects[3] = encryptedPass;
        }
        jdbcTemplate.batchUpdate("INSERT INTO user(id,email,name,password,username,role_id) VALUES (?,?,?,?,?,?)", userDataDefault);
    }


    private void initDefaultDepartmentAndEmployeeTable() {
        jdbcTemplate.batchUpdate("INSERT INTO department(id,name) VALUES (?,?)", departmentDataDefault);
        jdbcTemplate.batchUpdate("INSERT INTO employee(id,age,name,department_id) VALUES (?,?,?,?)", employeeDataDefault);
    }

    private void initDefaultPhoneTable() {
        jdbcTemplate.batchUpdate("INSERT INTO phone(id,number,employee_id) VALUES (?,?,?)", phoneDataDefault);
    }


}
