package springcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.sql.DataSource;
import java.sql.DriverManager;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringCourseApplication {

    @Bean
    HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/springcourse");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");

        return  dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCourseApplication.class, args);
    }

}
