package com.example.dbscript.init;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/init")
public class DbInitController {

    @Autowired
    DbPersistService dbPersistService;

    @GetMapping("/script")
    public void initDefaultTablesWithData() {
        dbPersistService.initAllTables();
    }
}
