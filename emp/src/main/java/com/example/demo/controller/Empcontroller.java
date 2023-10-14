package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Empdata;
import com.example.demo.repo.Repo;

@CrossOrigin(origins="http://localhost:3004")
@RestController
@RequestMapping("api/v")
public class Empcontroller {
	
	@Autowired
	private Repo r;
	@GetMapping("/employees")
	public List<Empdata> getAllEmployee()
	{
		return r.findAll();
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Empdata> getObjectById(@PathVariable Long id) {
	    // Logic to retrieve the object with the given ID
	    Empdata object = r.findById(id).orElse(null);

	    if (object != null) {
	        return ResponseEntity.ok(object);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	@PostMapping("/employees")
	public ResponseEntity<Empdata> createObject(
	        @RequestParam("empid") Long empid,
	        @RequestParam("empname") String empname,
	        @RequestParam("empemail") String empemail) {

	    Empdata object = new Empdata(empid, empname, empemail);
	    Empdata savedObject = r.save(object);
	    return ResponseEntity.ok(savedObject);
	}

	@PutMapping("/employees/{id}/update-column")
	public ResponseEntity<Empdata> updateColumn(@PathVariable Long id, @RequestParam String name,@RequestParam String email) {
	    Optional<Empdata> optionalObject = r.findById(id);
	    if (optionalObject.isPresent()) {
	        Empdata object = optionalObject.get();
	        object.setEmpname(name);
	        object.setEmpemail(email);
	        Empdata updatedObject = r.save(object);
	        return ResponseEntity.ok(updatedObject);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Void> deleteObject(@PathVariable Long id) {
	    Optional<Empdata> optionalObject = r.findById(id);
	    if (optionalObject.isPresent()) {
	        r.deleteById(id);
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
