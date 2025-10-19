package com.example.employeeapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nama tidak boleh kosong")
    @Size(max = 100, message = "Nama maksimal 100 karakter")
    private String name;

    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Format email tidak valid")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Posisi harus diisi")
    private String position;

    @NotNull(message = "Gaji tidak boleh kosong")
    @PositiveOrZero(message = "Gaji tidak boleh negatif")
    private Double salary;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
