package com.csc340.restapidemo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.csc340.restapidemo.Student;
import com.csc340.restapidemo.StudentRepository;
import org.springframework.web.client.RestTemplate;


@RestController
public class StudentController {

    @Autowired
    StudentRepository repo;
    //get all the students
    // localhost:8080/students
    @GetMapping("/students/all")
    public List<Student> getAllStudents() {
        List<Student> students = repo.findAll();
        return students;

    }



    //localhost:8080/students/1
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = repo.findById(id).get();

        return student;
    }


    @PostMapping("/students/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
        repo.save(student);
    }


    @PutMapping("/students/update/{id}")
    public Student updateStudents(@PathVariable int id) {
        Student student = repo.findById(id).get();
        student.setName("sample student1");
        student.setMajor("eng");
        student.setGpa(3.54);
        repo.save(student);
        return student;
    }


    @DeleteMapping("/students/delete/{id}")
    public void removeStudent(@PathVariable int id) {
        Student student = repo.findById(id).get();
        repo.delete(student);
    }

    // Get a random cat fact
    // Endpoint: localhost:8080/cat-fact
    @GetMapping("/cat-fact")
    public Object getCatFact() {
        try {
            String url = "https://cat-fact.herokuapp.com/facts/random";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            // Fetch the cat fact from the API
            String jsonResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonResponse);

            // Extract relevant information from the JSON response
            String factText = root.get("text").asText();
            System.out.println("Cat Fact: " + factText);

            return root;

        } catch (Exception ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            return "error in /cat-fact";
        }
    }

}




