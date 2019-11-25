package com.learn.orm.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.orm.entity.DevPgJoin;
import com.learn.orm.entity.DevPgToRevJoin;
import com.learn.orm.entity.ProjectGroup;
import com.learn.orm.repository.DevPgJoinRepository;
import com.learn.orm.repository.DevPgToRevJoinRepository;
import com.learn.orm.repository.ProjectGroupRepository;
import com.learn.orm.repository.UserRepository;



@RestController
@RequestMapping("/sample")
public class OrmController {

	@Autowired
	ProjectGroupRepository projectGroupRepository;
	@Autowired
	DevPgJoinRepository devPgJoinRepository;
	@Autowired
	DevPgToRevJoinRepository devPgToRevJoinRepository;
	
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@GetMapping("/save")
	public void saveProjectGroup() {
		
		ArrayList<String> repoList = new ArrayList<String>();
		repoList.add("Pos-register");
		repoList.add("Carbon");
		repoList.add("As400moon");
		
		ArrayList<String> devList = new ArrayList<String>();
		
		devList.add("tsharmmx");
		devList.add("dsharm7m");
		
		ArrayList<String> revList = new ArrayList<String>();
		revList.add("rbhattu3");
		revList.add("dsharm7m");
		
		
		ProjectGroup pg = new ProjectGroup();
		pg.setPgName("Tesla");
		pg.setProjectName("POS");
		pg.setTeamName("Waymo");
		pg.setUser(userRepository.findById("tsharmmx").get());
		
		projectGroupRepository.save(pg);
		
		Set<DevPgJoin> dPgSet = new HashSet<DevPgJoin>();
		
		for(String d:devList) {
			
			DevPgJoin a = new DevPgJoin();
			a.setDeveloper(userRepository.findById(d).get());
			a.setId(pg.getPgName()+a.getDeveloper().getAuthId());
			a.setProjectGroup(pg);
			devPgJoinRepository.save(a);
			dPgSet.add(a);
		}
		
		pg.setDevpgjoinSet(dPgSet);
		
		for(DevPgJoin d:dPgSet) {
			
			Set<DevPgToRevJoin> drSet = new HashSet<DevPgToRevJoin>(); 
		
			for(String s:revList) {
				
				DevPgToRevJoin dr = new DevPgToRevJoin();
				dr.setDevPgJoin(d);
				dr.setReviewer(userRepository.findById(s).get());
				devPgToRevJoinRepository.save(dr);
				drSet.add(dr);
			}
			
			d.setDevPgToRevJoinSet(drSet);
		}
		
		
	}
	
	
	@GetMapping("/delete")
	public void deletePg() {
		
		projectGroupRepository.delete(projectGroupRepository.findById("Tesla").get());
		
		
		
	}
	
	@GetMapping("/changeDevelopers")
	public void updateDev() {
		
		
		
		
		String pgName = "Tesla";
		String devId = "tsharmmx";
		
		devPgJoinRepository.delete(devPgJoinRepository.findById(pgName+devId).get());
		
		Set<DevPgJoin> set1 = projectGroupRepository.findById("Tesla").get().getDevpgjoinSet();
		ArrayList<String> str1 = new ArrayList<String>(); 
		
		for(DevPgJoin d:set1) {
			
			str1.add(d.getDeveloper().getAuthId());
			
		}
		
		System.out.println(str1);
		
//		Set<DevPgJoin> set2 = projectGroupRepository.findById("Tesla").get().getDevpgjoinSet();
//		
//		for(DevPgJoin d:set2) {
//			
//			System.out.println(d.getDeveloper().getAuthId());
//			
//		}
		
	}
	
	
}
