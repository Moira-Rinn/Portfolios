package com.sacha.portfolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacha.portfolio.models.Project;
import com.sacha.portfolio.repositories.ProjectRepo;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepo projectRepository;
	
	//GET ALL
		public List<Project> all(){
			return projectRepository.findAll();
		}
	//GET ONE 
	//Find By ID
		public Optional<Project> findById(Long id) {
			return projectRepository.findById(id);
		}
	//ADD
		public Project add(Project project) {
			return projectRepository.save(project);
		}
	//UPDATE
		public Project update(Project project, Long id) {
			return projectRepository.save(project);
	}
	//DELETE
		public void delete(Long id) {
			projectRepository.deleteById(id);
		}
	//DELETE BOOK AND ASSOCIATED STARS
//		public void delete(List<Star> allStars, Long projectId) {
//			for(Star star : allStars) {
//				Project project = star.getStarred();
//				if(project.getId() == projectId) 
//					starsRepository.deleteById(star.getId());
//			}	
		}