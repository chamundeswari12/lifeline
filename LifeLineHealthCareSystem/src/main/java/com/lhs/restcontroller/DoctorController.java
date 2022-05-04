package com.lhs.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhs.dao.DoctorRepo;
import com.lhs.entity.Doctor;
import com.lhs.entity.SlotBooking;
import com.lhs.service.DoctorService;

@RestController
//@RequestMapping("/api")
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	@Autowired
	DoctorRepo doctorRepo;

	@PostMapping("/addingDoctors")
	public ResponseEntity<String> addingcontroller(@RequestBody Doctor doc) {

		doctorService.addingDoctor(doc);

		return ResponseEntity.ok("added account sucessfully " + doc.getDoctorName());

	}

	@GetMapping("/gettingdoctor")
	public List<Doctor> gettingall(@RequestBody Doctor doc) {

		List<Doctor> f = doctorService.findingall(doc);
		System.out.println(f);
		return f;

		// return doctorRepo.findBySpecialistAndLocation(specialist, location);

	}

}
