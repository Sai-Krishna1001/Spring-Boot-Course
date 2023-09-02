package com.krishna.ems.controller;

import com.krishna.ems.dto.DepartmentDto;
import com.krishna.ems.dto.EmployeeDto;
import com.krishna.ems.entity.Department;
import com.krishna.ems.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class  DepartmentController {

    private DepartmentService departmentService;

    // Build Add Department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    // Build Get Department REST API
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentByDto(@PathVariable("id") Long departmentId){
        DepartmentDto department = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(department);
    }

    // Build Get All Departments REST API
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<DepartmentDto> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    // Build Update Department REST API
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                         @RequestBody DepartmentDto updatedDepartment){
        DepartmentDto department =  departmentService.updateDepartment(departmentId, updatedDepartment);
        return ResponseEntity.ok(department);
    }

    // Build Delete Department REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Successfully Deleted Department");
    }

}
