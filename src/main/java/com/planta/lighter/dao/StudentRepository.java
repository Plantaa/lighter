package com.planta.lighter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.planta.lighter.entity.Student;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
