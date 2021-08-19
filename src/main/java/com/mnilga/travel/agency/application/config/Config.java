package com.mnilga.travel.agency.application.config;

import com.mnilga.travel.agency.application.converter.RoleConverterToDto;
import com.mnilga.travel.agency.application.converter.RoleDtoConverterToRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan
@Configuration
public class Config implements WebMvcConfigurer {

    private RoleConverterToDto roleConverterToDto;
    private RoleDtoConverterToRole roleDtoConverterToRole;

    @Autowired
    public void setRoleConverterToDto(RoleConverterToDto roleConverterToDto) {
        this.roleConverterToDto = roleConverterToDto;
    }

    @Autowired
    public void setRoleDtoConverterToRole(RoleDtoConverterToRole roleDtoConverterToRole) {
        this.roleDtoConverterToRole = roleDtoConverterToRole;
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleDtoConverterToRole);
        registry.addConverter(roleConverterToDto);
    }
}
