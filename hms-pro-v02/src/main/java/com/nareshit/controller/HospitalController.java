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

import com.nareshit.bean.HospitalBean;
import com.nareshit.domain.Hospital;
import com.nareshit.repository.IHospitalRepository;
import com.nareshit.service.HospitalService;
import com.nareshit.utility.HospitalMapper;

//@RestController
@Controller
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private IHospitalRepository hospRepo;
	
	@Autowired
	private HospitalService hospService;
	
	@RequestMapping
	public String getHomePage(Model model) {
		String msg = "welcome to hms pro";
		model.addAttribute("message", msg);
		model.addAttribute("hospBean", new HospitalBean());
		
		return "home";
	}
	
		
	@GetMapping(value="/addHospitalPage")
	public String addHospotal(Model model) {
		System.out.println("get hospital page");
		model.addAttribute("hospBean", new HospitalBean());
		return "addHospital";
	}
	
	@GetMapping(value="/addHospitalDefn")
	public String addHospotalDefinition(Model model) {
		System.out.println("get hospital page");
		model.addAttribute("hospBean", new HospitalBean());
		return "addHospitalDefn";
	}
	
	@GetMapping(value="/getHospitalBoard")
	public String getHospotalBoard(Model model) {
		System.out.println("get hospital page");
		model.addAttribute("hospBean", new HospitalBean());
		Iterator<Hospital> hospDomainsList = hospRepo.findAll().iterator();
		List<HospitalBean> hospBeanList = HospitalMapper.mapDomainListToBean(hospDomainsList);
		model.addAttribute("hospList", hospBeanList);
		return "hospBoard";
				
		
	}
	
	@GetMapping(value="/searchAllHosp")
	public String searchAllHosp(HttpServletRequest req,Model model) {
		System.out.println("am in search all hsopiatls");
		
		
		String searchVal = req.getParameter("searchValue");
		String searchOption = req.getParameter("searchOption");
		System.out.println("search val is:\t"+searchVal);
		System.out.println("search option is:\t"+searchOption);
		
		if(searchOption != null && !searchOption.isEmpty()) {
			if(searchOption.equals("Name")) {
				List<Hospital> hospDomainList = hospRepo.findHospitalByName(searchVal.toLowerCase());
				List<HospitalBean> hospBeanList = HospitalMapper.mapDomainListToBean(hospDomainList.iterator());
				model.addAttribute("hospList", hospBeanList);
			}
		}else {
			model.addAttribute("errorMessage", "Search is not supplied.");
		}
		
		return "hospBoard";
				
		
	}
	
	/*@PostMapping(value="/addHospital")
	public String addHospotal(@ModelAttribute("hospBean") HospitalBean hospBean) {
		System.out.println("add hospital ");
		System.out.println("hospal data is:\t"+hospBean.getStatus());
		Hospital hosp = HospitalMapper.mapBeanToDomain(hospBean);
		hosp = hospRepo.save(hosp);
		hospBean = HospitalMapper.mapDomainToBean(hosp);
		//return "addHospital";
		return "redirect:./getAllHospitals";
		
	}*/
	
	@PostMapping(value="/addHospital")
	public String addHospotal(@ModelAttribute("hospBean") HospitalBean hospBean, Model model) {
		System.out.println("add hospital ");
		System.out.println("hospal data is:\t"+hospBean.getStatus());
		Hospital hosp = HospitalMapper.mapBeanToDomain(hospBean);
		//hosp = hospRepo.save(hosp);
		hospBean =  hospService.saveHospital(hosp);
		//hospBean = HospitalMapper.mapDomainToBean(hosp);
		Iterator<Hospital> hospDomainsList = hospRepo.findAll().iterator();
		List<HospitalBean> hospBeanList = HospitalMapper.mapDomainListToBean(hospDomainsList);
		model.addAttribute("hospList", hospBeanList);
		//return "addHospital";
		
		
		
		return "hospBoard";
		
	}
	
	@GetMapping(value="/getAllHospitals")
	public String  findHospotal(Model  model) {
		Iterator<Hospital> hospDomainsList = hospRepo.findAll().iterator();
		List<HospitalBean> hospBeanList = HospitalMapper.mapDomainListToBean(hospDomainsList);
		model.addAttribute("hospList", hospBeanList);
		
		return "hospList";
	}
	
	@GetMapping(value="/deleteHosp/{id}")
	public String  delteHospotal(Model  model,@PathVariable("id") int id) {
		hospRepo.delete(id);
		Iterator<Hospital> hospDomainsList = hospRepo.findAll().iterator();
		List<HospitalBean> hospBeanList = HospitalMapper.mapDomainListToBean(hospDomainsList);
		model.addAttribute("hospList", hospBeanList);
		return "hospList";
	}
	
	@GetMapping(value="/editHosp/{id}")
	public String  editHospotal(Model  model,@PathVariable("id") int id) {
		Hospital hosp = hospRepo.findOne(id);
		HospitalBean hospBean = HospitalMapper.mapDomainToBean(hosp);
		model.addAttribute("hospBean", hospBean);
		return "editHospital";
	}
	
	@PostMapping(value="/updateHospital")
	public String updateHospotal(@ModelAttribute("hospBean") HospitalBean hospBean) {
		System.out.println("add hospital ");
		System.out.println(hospBean.getHospId());
		System.out.println(hospBean.getEmail());
		Hospital hosp = HospitalMapper.mapBeanToDomain(hospBean);
		hosp = hospRepo.save(hosp);
		hospBean = HospitalMapper.mapDomainToBean(hosp);
		//return "addHospital";
		return "redirect:./getAllHospitals";
		
	}
}
