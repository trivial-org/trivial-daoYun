package org.fzu.cs03.daoyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DaoyunApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaoyunApplication.class, args);
        System.out.println("tst");
    }


}
