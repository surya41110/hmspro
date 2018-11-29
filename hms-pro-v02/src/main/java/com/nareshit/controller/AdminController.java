package com.nareshit.controller;

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
import com.nareshit.bean.NurseBean;
import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Nurse;
import com.nareshit.domain.Patient;
import com.nareshit.service.DoctorService;
import com.nareshit.service.NurseService;
import com.nareshit.service.PatientService;
import com.nareshit.utility.NurseMapper;
import com.nareshit.utility.PatientMapper;


//@RestController
@Controller
@RequestMapping("/admin")
public class AdminController {
	

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patService;
	
	@Autowired
	private NurseService nurseService;
	
	@RequestMapping
	public String getAdminBoard(Model model) {
		List<DoctorBean> docBeanList = doctorService.getAllDoctors();
		model.addAttribute("docBeanList", docBeanList);
		return "adminBoard";
				
	}
	
	@RequestMapping(value="/doctorMgmt")
	public String getDoctorBoard(Model model) {
		List<DoctorBean> docBeanList = doctorService.getAllDoctors();
		model.addAttribute("docBeanList", docBeanList);
		return "adminBoard";
	}
	
	@RequestMapping(value="/patientMgmt")
	public String getPatientBoard(Model model) {
		List<PatientBean> patBeanList = patService.getAllPatients();
		model.addAttribute("patBeanList", patBeanList);
		return "adminPatientBoard";
	}
	
	@RequestMapping(value="/doctorMgmt/addDoctorDefn")
	public String addDoctorByAdmin(Model model) {
		System.out.println("get doctor page in admin");
		model.addAttribute("doctBean", new DoctorBean());
		return "addDoctorDefnByAdmin";
	}
	
	@RequestMapping(value="/patientMgmt/addPatientDefn")
	public String addPatientByAdmin(Model model) {
		System.out.println("get patient page in admin");
		model.addAttribute("patBean", new PatientBean());
		return "addPatientDefnByAdmin";
	}
	
	@RequestMapping(value="/doctorMgmt/addDoctor")
	public String addpatotal(@ModelAttribute("doctBean") DoctorBean doctBean, Model model) {
		System.out.println("add Patient ");
		System.out.println("patal data is:\t"+doctBean.getStatus());
		doctBean =  doctorService.saveDoctor(doctBean);
		if(doctBean != null && doctBean.getId() >0) {
			List<DoctorBean> docBeanList = doctorService.getAllDoctors();
			model.addAttribute("docBeanList", docBeanList);
		}
		return "adminBoard";
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
	

	@GetMapping(value = "/doctorMgmt/searchDoctor")
	public String searchDoctorByNameOrEmail(HttpServletRequest req,Model model) {
		System.out.println("search patient");
		String searchVal = req.getParameter("searchValue");
		String searchOption = req.getParameter("searchOption");
		if(searchOption != null && !searchOption.isEmpty()) {
			if(searchOption.equals("Name")||searchOption.equals("Email")) {
			List<DoctorBean> docBeanList = doctorService.searchDoctor(searchVal, searchOption);
			System.out.println(docBeanList);
			model.addAttribute("docBeanList", docBeanList);
			}
		}
		return "adminBoard";
	}

	@GetMapping(value = "/doctorMgmt/editDoc/{id}")
	public String editDoctor(Model model, @PathVariable("id") int id) {
		DoctorBean doctorBean = doctorService.getDoctorByid(id);
		model.addAttribute("docBean", doctorBean);
		return "adminDoctorEditBoard";
	}

	@PostMapping(value = "/doctorMgmt/updateDoctor")
	public String updateDoctor(@ModelAttribute("docBean") DoctorBean doctorBean, Model model) {
		System.out.println("update Doc ");
		System.out.println(doctorBean.getId());
		System.out.println(doctorBean.getEmail());
		doctorBean = doctorService.updateDoctor(doctorBean);
		if (doctorBean != null && doctorBean.getId() > 0) {
			List<DoctorBean> docBeanList = doctorService.getAllDoctors();
			model.addAttribute("docBeanList", docBeanList);
		}
		return "adminBoard";

	}

	@GetMapping(value = "/doctorMgmt/deleteDoct/{id}")
	public String deleteDoctor(Model model, @PathVariable("id") int id) {
		System.out.println("doc conn del");
		doctorService.deleteDoctor(id);
		List<DoctorBean> docBeanList = doctorService.getAllDoctors();
		model.addAttribute("docBeanList", docBeanList);
		return "adminBoard";
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
	
	
	@RequestMapping(value="/nurseMgmt")
	public String getNurseBoard(Model model) {
		List<NurseBean> nurBeanList = nurseService.getAllNurses();
		model.addAttribute("nurBeanList", nurBeanList);
		return "adminNurseBoard";
	}
	
	@RequestMapping(value="/nurseMgmt/addNurse")
	public String addNurse(@ModelAttribute("nurBean") NurseBean nurBean, Model model) {
		System.out.println("add Nur ");
		System.out.println("patal data is:\t"+nurBean.getStatus());
		nurBean = nurseService.saveNurse(nurBean);
		if(nurBean != null && nurBean.getId() >0) {
			List<NurseBean> nurBeanList = nurseService.getAllNurses();
			model.addAttribute("nurBeanList", nurBeanList);
		}
		return "adminNurseBoard";
	}
	@RequestMapping(value="nurseMgmt/addNurseDefn")
	public String addNurseByAdmin(Model model) {
		System.out.println("get patient page in admin");
		model.addAttribute("nurBean", new NurseBean());
		return "addNurseDefnByAdmin";
	}
	
	@GetMapping(value="/nursetMgmt/editNur/{id}")
	public String  editNurse(Model  model,@PathVariable("id") int id) {
		NurseBean nurBean = nurseService.getNurseByid(id);
		model.addAttribute("nurBean", nurBean);
		return "adminNurseEditBoard";
	}
	
	@PostMapping(value="/nurseMgmt/updateNurse")
	public String updateNurse(@ModelAttribute("nurBean") NurseBean nurBean,Model model) {
		System.out.println("add Nurse ");
		System.out.println(nurBean.getId());
		System.out.println(nurBean.getEmail());
		nurBean = nurseService.updateNurse(nurBean);
		if(nurBean != null && nurBean.getId() >0) {
			List<NurseBean> nurBeanList = nurseService.getAllNurses();
			model.addAttribute("nurBeanList", nurBeanList);
		}
		return "adminNurseBoard";
		
	}
	

	@GetMapping(value = "/nurseMgmt/searchNurse")
	public String searchNurseByNameOrEmail(HttpServletRequest req,Model model) {
		System.out.println("search Nurse");
		String searchVal = req.getParameter("searchValue");
		String searchOption = req.getParameter("searchOption");
		if(searchOption != null && !searchOption.isEmpty()) {
			if(searchOption.equals("Name")||searchOption.equals("Email")) {
			List<NurseBean> nurBeanList = nurseService.searchNurse(searchVal, searchOption);
			System.out.println(nurBeanList);
			model.addAttribute("nurBeanList", nurBeanList);
			}
		}
		return "adminNurseBoard";
	}
	
	
}
