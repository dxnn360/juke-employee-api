package com.example.employeeapi.controller;

import com.example.employeeapi.model.Employee;
import com.example.employeeapi.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    // GET: semua karyawan
    @GetMapping
    public List<Employee> getAllEmployees() {
        log.info("Mendapatkan semua data karyawan");
        return service.getAllEmployees();
    }

    // GET: karyawan berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        log.info("Mendapatkan data karyawan dengan id: {}", id);
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    // POST: tambah karyawan baru
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        log.info("Membuat karyawan baru dengan email: {}", employee.getEmail());
        Employee saved = service.createEmployee(employee);
        return ResponseEntity.ok(saved);
    }

    // PUT: update data karyawan
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee
            
    ) {
        log.info("Memperbarui data karyawan dengan id: {}", id);
        return ResponseEntity.ok(service.updateEmployee(id, employee));
    }

    // DELETE: hapus karyawan
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        log.info("Menghapus karyawan dengan id: {}", id);
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
