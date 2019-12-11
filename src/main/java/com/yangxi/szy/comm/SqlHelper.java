package com.yangxi.szy.comm;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;

import javax.sql.DataSource;

public class SqlHelper {
    //MSSQL驱动
    public static String MSSQL_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    //MYSQL 驱动
    public static String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

    //ORACLE 驱动
    public static String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";

    //得到会话对象
    public static SqlSessionFactory getSession(DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        org.apache.ibatis.session.Configuration ibatisConfiguration =
                new org.apache.ibatis.session.Configuration();
        ibatisConfiguration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(ibatisConfiguration);

        //设置个性化数据源
        sqlSessionFactoryBean.setDataSource(dataSource);

        return sqlSessionFactoryBean.getObject();
    }

    //得到定制数据源
    public static DataSource getDataSource(String driver, String url,
                                           String usr, String pwd) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(usr);
        dataSource.setPassword(pwd);

        return dataSource;
    }
}
