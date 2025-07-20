package com.xl.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        //定义bean，SqlSessionFactoryBean，用于产生SqlSessionFactory对象
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        //设置模型类的别名扫描,在springboot中会自动扫描整个包下的
        sqlSessionFactory.setTypeAliasesPackage("com.xl.domain");
        //设置数据源
        sqlSessionFactory.setDataSource(dataSource);
        return sqlSessionFactory;
    }
    //定义bean，返回MapperScannerConfigurer对象
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //这个在springboot中就要在接口上加上@Mapper注解，就不用配置包的路径了
        msc.setBasePackage("com.xl.dao");
        return msc;
    }
}
