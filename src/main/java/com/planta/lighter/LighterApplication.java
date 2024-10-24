package com.planta.lighter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.planta.lighter.dao.EmployeeRepository;
import com.planta.lighter.dao.StudentDAO;
import com.planta.lighter.entity.Employee;
import com.planta.lighter.entity.Student;

@SpringBootApplication
public class LighterApplication {

	public static void main(String[] args) {
		SpringApplication.run(LighterApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO, EmployeeRepository employeeRepository) {
		return runner -> {
			createMultipleStudents(studentDAO, employeeRepository);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO, EmployeeRepository employeeRepository) {

		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// create multiple employees
		System.out.println("Creating 3 employees objects ...");
		Employee tempEmployee1 = new Employee("John", "Doe", "john@luv2code.com");
		Employee tempEmployee2 = new Employee("Mary", "Public", "mary@luv2code.com");
		Employee tempEmployee3 = new Employee("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the students ...");
		employeeRepository.save(tempEmployee1);
		employeeRepository.save(tempEmployee2);
		employeeRepository.save(tempEmployee3);
	}
}
