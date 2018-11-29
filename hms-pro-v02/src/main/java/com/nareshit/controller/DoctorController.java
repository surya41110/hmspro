package com.nareshit.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nareshit.bean.DoctorBean;
import com.nareshit.bean.HospitalBean;
import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Doctor;
import com.nareshit.domain.Hospital;
import com.nareshit.domain.Patient;
import com.nareshit.service.DoctorService;
import com.nareshit.service.PatientService;
import com.nareshit.utility.DoctorMapper;
import com.nareshit.utility.HospitalMapper;
import com.nareshit.utility.PatientMapper;

//@RestController
@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patService;
	
	@RequestMapping
	public String getDocorBoard(HttpServletRequest request,Model model) {
		System.out.println("logged in session id is:\t"+request.getSession().getId());
		//return "doctBoard";
		List<PatientBean> patBeanList = patService.getAllPatients();
		model.addAttribute("patBeanList", patBeanList);
		return "doctorPatientBoard";
	}
	
	@GetMapping(value="/addDoctorDefn")
	public String addHospotal(Model model) {
		System.out.println("get doctor page");
		model.addAttribute("doctBean", new DoctorBean());
		return "addDoctorDefn";
	}
	

	@PostMapping(value="/addDoctor")
	public String addHospotal(@ModelAttribute("doctBean") DoctorBean doctBean, Model model) {
		System.out.println("add hospital ");
		System.out.println("hospal data is:\t"+doctBean.getStatus());
		//Doctor doct = DoctorMapper.mapBeanToDomain(doctBean);
		//hosp = hospRepo.save(hosp);
		doctBean =  doctorService.saveDoctor(doctBean);
		if(doctBean != null && doctBean.getId() >0) {
			List<DoctorBean> docBeanList = doctorService.getAllDoctors();
			model.addAttribute("docBeanList", docBeanList);
		}
		return "doctBoard";
	}
	
	@RequestMapping(value="/patientMgmt")
	public String getPatientBoard(Model model) {
		List<PatientBean> patBeanList = patService.getAllPatients();
		model.addAttribute("patBeanList", patBeanList);
		return "doctorPatientBoard";
	}
	
	@RequestMapping(value="/patientMgmt/addPatientDefn")
	public String addPatientByAdmin(Model model) {
		System.out.println("get patient page in admin");
		model.addAttribute("patBean", new PatientBean());
		return "addPatientDefnByAdmin";
	}
	
	@RequestMapping(value="/patientMgmt/addPatient")
	public String addPatient(@ModelAttribute("patBean") PatientBean patBean, Model model) {
		System.out.println("add Patient ");
		System.out.println("patal data is:\t"+patBean.getStatus());
		Patient pat = PatientMapper.mapBeanToDomain(patBean);
		//pat = patRepo.save(pat);
		patBean =  patService.savePatient(pat);
		if(patBean != null && patBean.getId() >0) {
			List<PatientBean> patBeanList = patService.getAllPatients();
			model.addAttribute("patBeanList", patBeanList);
		}
		return "adminPatientBoard";
	}
	
	@GetMapping(value="/patientMgmt/editPat/{id}")
	public String  editPatient(Model  model,@PathVariable("id") int id) {
		PatientBean patBean = patService.getPatientById(id);
		model.addAttribute("patBean", patBean);
		return "adminPatientEditBoard";
	}
	
	@PostMapping(value="/patientMgmt/updatePatient")
	public String updatePatient(@ModelAttribute("patBean") PatientBean patBean,Model model) {
		System.out.println("add Patient ");
		System.out.println(patBean.getId());
		System.out.println(patBean.getEmail());
		Patient pat = PatientMapper.mapBeanToDomain(patBean);
		patBean = patService.updatePatient(pat);
		if(patBean != null && patBean.getId() >0) {
			List<PatientBean> patBeanList = patService.getAllPatients();
			model.addAttribute("patBeanList", patBeanList);
		}
		return "adminPatientBoard";
		
	}
	
	@GetMapping(value = "/patientMgmt/searchPatient")
	public String searchPatientByNameOrEmail(HttpServletRequest req,Model model) {
		System.out.println("search patient");
		String searchVal = req.getParameter("searchValue");
		String searchOption = req.getParameter("searchOption");
		if(searchOption != null && !searchOption.isEmpty()) {
			if(searchOption.equals("Name")||searchOption.equals("Email")) {
			List<PatientBean> patBeanList = patService.searchPatient(searchVal, searchOption);
			System.out.println(patBeanList);
			model.addAttribute("patBeanList", patBeanList);
			}
		}
		return "adminPatientBoard";
	}

	
	
	
}
