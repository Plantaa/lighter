package com.planta.lighter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LighterApplication {

	public static void main(String[] args) {
		SpringApplication.run(LighterApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(StudentRepository studentRepository, EmployeeRepository employeeRepository) {
	// 	return runner -> {
	// 		createMultipleStudents(studentRepository, employeeRepository);
	// 	};
	// }

	// private void createMultipleStudents(StudentRepository studentRepository, EmployeeRepository employeeRepository) {

	// 	// create multiple students
	// 	System.out.println("Creating 3 student objects ...");
	// 	Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
	// 	Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
	// 	Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

	// 	// save the student objects
	// 	System.out.println("Saving the students ...");
	// 	studentRepository.save(tempStudent1);
	// 	studentRepository.save(tempStudent2);
	// 	studentRepository.save(tempStudent3);

	// 	// create multiple employees
	// 	System.out.println("Creating 3 employees objects ...");
	// 	Employee tempEmployee1 = new Employee("John", "Doe", "john@luv2code.com");
	// 	Employee tempEmployee2 = new Employee("Mary", "Public", "mary@luv2code.com");
	// 	Employee tempEmployee3 = new Employee("Bonita", "Applebum", "bonita@luv2code.com");

	// 	// save the student objects
	// 	System.out.println("Saving the students ...");
	// 	employeeRepository.save(tempEmployee1);
	// 	employeeRepository.save(tempEmployee2);
	// 	employeeRepository.save(tempEmployee3);
	// }
}
