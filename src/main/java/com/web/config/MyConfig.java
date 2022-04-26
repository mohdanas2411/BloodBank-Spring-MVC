package com.web.config;

import com.web.dao.admin.AdminDao;
import com.web.dao.admin.AdminDaoImple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.web")
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Bean
    public DataSource getDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/bloodBank");
        dataSource.setUsername("root");
        dataSource.setPassword("Admin@12345");
        return dataSource;

    }

//    @Bean
//    public AdminDao getAdminDao(){
//        return new AdminDaoImple(getDataSource());
//    }



    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

    @Bean
    public AdminDao adminDAO(){
        AdminDaoImple adminDaoImple = new AdminDaoImple();
        adminDaoImple.setJdbcTemplate(jdbcTemplate());
        return adminDaoImple;
    }
}
