package com.art;


import com.art.dao.RegionDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);
        RegionDao bean = context.getBean(RegionDao.class);
        System.out.println(bean.findAll());
    }
}
