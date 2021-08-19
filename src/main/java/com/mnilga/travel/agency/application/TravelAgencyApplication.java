package com.mnilga.travel.agency.application;

import com.mnilga.travel.agency.application.service.RoleService;
import com.mnilga.travel.agency.application.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TravelAgencyApplication {

	//for testing role dto converter
	private RoleServiceImpl roleServiceImp;

	@Autowired
	public void setRoleServiceImp(RoleServiceImpl roleServiceImp) {
		this.roleServiceImp = roleServiceImp;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void test() {
		roleServiceImp.test();
	}




	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyApplication.class, args);

	}


}
