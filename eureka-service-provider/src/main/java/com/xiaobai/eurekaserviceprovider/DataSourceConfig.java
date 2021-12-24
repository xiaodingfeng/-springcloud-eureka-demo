package com.xiaobai.eurekaserviceprovider;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author dingfeng.xiao
 */
@Configuration
public class DataSourceConfig {


    @Resource
    private Environment env;

    @Bean
    public ServletRegistrationBean<Servlet> druidServlet() {
        ServletRegistrationBean<Servlet> reg = new ServletRegistrationBean<>();
        reg.setServlet(new StatViewServlet());
        // 登录URL http://localhost:8080/d/login.html
        reg.addUrlMappings("/druid/*");
        // 设置白名单
        reg.addInitParameter("allow", "");
        // 设置黑名单
        reg.addInitParameter("deny", "");
        // 设置登录查看信息的账号密码.
        reg.addInitParameter("loginUsername", "admin");
        reg.addInitParameter("loginPassword", "admin");
        return reg;
    }

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions",
                "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    @Bean(name = {"dataSource", "masterDataSource"})
    @Primary
    public DataSource masterDataSource() throws SQLException {
        try (DruidDataSource dataSource = new DruidDataSource()) {
            dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
            dataSource.setUrl(env.getProperty("spring.datasource.url"));
            dataSource.setUsername(env.getProperty("spring.datasource.username"));
            dataSource.setPassword(env.getProperty("spring.datasource.password"));
            dataSource.addFilters("stat");
            dataSource.addFilters("wall");
            return dataSource;
        }
    }
}
