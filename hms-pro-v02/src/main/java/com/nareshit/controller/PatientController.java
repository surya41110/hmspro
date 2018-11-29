package com.nareshit.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Patient;
import com.nareshit.service.PatientService;
import com.nareshit.utility.PatientMapper;

//@RestController
@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService PatientService;
	
	@RequestMapping
	public String getDocorBoard() {
		return "patBoard";
				
	}
	
	@GetMapping(value="/addPatientDefn")
	public String addHospotal(Model model) {
		System.out.println("get Patient page");
		model.addAttribute("patBean", new PatientBean());
		return "addPatientDefn";
	}
	

	@PostMapping(value="/addPatient")
	public String addHospotal(@ModelAttribute("patBean") PatientBean patBean, Model model) {
		System.out.println("add hospital ");
		System.out.println("hospal data is:\t"+patBean.getStatus());
		Patient pat = PatientMapper.mapBeanToDomain(patBean);
		//hosp = hospRepo.save(hosp);
		patBean =  PatientService.savePatient(pat);
		if(patBean != null && patBean.getId() >0) {
			List<PatientBean> patBeanList = PatientService.getAllPatients();
			model.addAttribute("patBeanList", patBeanList);
		}
		return "patBoard";
	}
	
	
	
	
}
