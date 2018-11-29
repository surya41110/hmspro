package com.nareshit.controller;

import java.util.ArrayList;
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

import com.nareshit.bean.RoleBean;
import com.nareshit.bean.PatientBean;
import com.nareshit.bean.PermissionBean;
import com.nareshit.bean.RoleBean;
import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Role;
import com.nareshit.domain.Patient;
import com.nareshit.domain.Permission;
import com.nareshit.domain.Patient;
import com.nareshit.service.PatientService;
import com.nareshit.service.PermissionService;
import com.nareshit.service.RoleService;
import com.nareshit.utility.RoleMapper;
import com.nareshit.utility.PatientMapper;
import com.nareshit.utility.PermissionMapper;
import com.nareshit.utility.PatientMapper;


//@RestController
@Controller
@RequestMapping("/superAdmin")
public class SuperAdminController {

	@Autowired
	private PermissionService permService;
	
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping
	public String getSuperAdminBoard(HttpServletRequest request,Model model) {
		System.out.println("session id is:\t"+request.getSession().getId());
		List<RoleBean> roleBeanList = roleService.getAllRoles();
		model.addAttribute("roleBeanList", roleBeanList);
		return "superAdminBoard";
				
	}
	
	@RequestMapping(value="/permMgmt")
	public String getSuperAdminPermBoard(Model model) {
		List<PermissionBean> permBeanList = permService.getAllPermissions();
		model.addAttribute("permBeanList", permBeanList);
		return "superAdminPermBoard";
				
	}
	
	@RequestMapping(value="/roleMgmt/addRoleDefn")
	public String addRoleByAdmin(Model model) {
		System.out.println("get role page in superadmin");
		model.addAttribute("roleBean", new RoleBean());
		List<PermissionBean> permBeanList = permService.getAllPermissions();
		List<String> permListBox = new ArrayList<String>();
		if(permBeanList != null && permBeanList.size() >0) {
			for(PermissionBean p : permBeanList) {
				permListBox.add(p.getPermission());
			}
			model.addAttribute("permListBox", permListBox);
		}
		return "addRoleDefn";
	}
	
	@RequestMapping(value="/permMgmt/addPermDefn")
	public String addPermission(Model model) {
		System.out.println("get role page in superadmin");
		model.addAttribute("permBean", new PermissionBean());
		return "addPermDefn";
	}
	
	//addRole
	
	@RequestMapping(value="/roleMgmt/addRole")
	public String addpatotal(@ModelAttribute("roleBean") RoleBean roleBean, Model model) {
		System.out.println("add role ");
		System.out.println("role data is:\t"+roleBean.getRole());
		
		for(String perm:roleBean.getPermissions()) {
			System.out.println("permission is:\t"+perm);
		}
		
		
		//pat = patRepo.save(pat);
		roleBean =  roleService.saveRole(roleBean);
		if(roleBean != null && roleBean.getId() >0) {
			List<RoleBean> roleBeanList = roleService.getAllRoles();
			model.addAttribute("roleBeanList", roleBeanList);
		}
		return "superAdminBoard";
	}
	
	@RequestMapping(value="/permMgmt/addPermission")
	public String addPermission(@ModelAttribute("permBean") PermissionBean permBean, Model model) {
		System.out.println("add permission ");
		System.out.println("permission data is:\t"+permBean.getPermission());
		Permission permission = PermissionMapper.mapBeanToDomain(permBean);
		//pat = patRepo.save(pat);
		permBean =  permService.savePermission(permission);
		if(permBean != null && permBean.getId() >0) {
			List<PermissionBean> permBeanList = permService.getAllPermissions();
			model.addAttribute("permBeanList", permBeanList);
		}
		return "superAdminPermBoard";
	}
	
	
	
}
