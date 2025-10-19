package com.example.employeeapi.service;

import com.example.employeeapi.model.Employee;
import com.example.employeeapi.repository.EmployeeRepository;
import com.example.employeeapi.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repo;

    public List<Employee> getAllEmployees() {
        log.debug("Mengambil semua data karyawan");
        return repo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        log.debug("Mengambil data karyawan dengan id: {}", id);
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Karyawan tidak ditemukan dengan id: " + id));
    }

    public Employee createEmployee(Employee employee) {
        if (repo.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("Email sudah digunakan!");
        }
        log.debug("Membuat karyawan baru dengan email: {}", employee.getEmail());
        employee.setId(null);
        return repo.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee existing = getEmployeeById(id);
        existing.setName(employeeDetails.getName());
        existing.setEmail(employeeDetails.getEmail());
        existing.setPosition(employeeDetails.getPosition());
        existing.setSalary(employeeDetails.getSalary());
        return repo.save(existing);
    }

    public void deleteEmployee(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Karyawan tidak ditemukan");
        }
        log.debug("Hapus data karyawan dengan ID: ", id);
        repo.deleteById(id);
    }
}
