package com.mnilga.travel.agency.application;

import com.mnilga.travel.agency.application.service.RoleService;
import com.mnilga.travel.agency.application.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TravelAgencyApplication {

	//for testing dto converters
	private RoleServiceImpl roleServiceImpl;
	private UserServiceImpl userServiceImpl;
	private HotelServiceImpl hotelServiceImpl;
	private RoomServiceImpl roomServiceImpl;
	private OrderServiceImpl orderServiceImpl;


	@Autowired
	public void setRoleServiceImpl(RoleServiceImpl roleServiceImpl) {
		this.roleServiceImpl = roleServiceImpl;
	}

	@Autowired
	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@Autowired
	public void setHotelServiceImpl(HotelServiceImpl hotelServiceImpl) {
		this.hotelServiceImpl = hotelServiceImpl;
	}

	@Autowired
	public void setRoomServiceImpl(RoomServiceImpl roomServiceImpl) {
		this.roomServiceImpl = roomServiceImpl;
	}

	@Autowired
	public void setOrderService(OrderServiceImpl orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}

	//for testing dto converters    + in Audit class init field UUID
	@EventListener(ApplicationReadyEvent.class)
	public void test() {
		//userServiceImpl.testDto();
		//roleServiceImpl.testDto();
		//hotelServiceImpl.testDto();
		//roomServiceImpl.testDto();
		//orderServiceImpl.testDto();
	}

	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyApplication.class, args);

	}


}
