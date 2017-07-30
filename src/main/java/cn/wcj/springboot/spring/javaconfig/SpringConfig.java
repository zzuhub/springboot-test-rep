package cn.wcj.springboot.spring.javaconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;
/**
 * 
 * <p>Module:SpringConfig </p>
 * <p>Description:Spring-JavaConfig 其中@Configuration<=>XML,@Bean<=>配置Bean </p>
 * <p>Company:Software College Of ZhengZhou University </p> 
 * @author SuccessKey(WangCJ)
 * @date 2017年7月30日 上午10:29:43
 */
@PropertySource(value={"jdbc.properties"},ignoreResourceNotFound=true)
@ComponentScan(basePackages={"cn.wcj.springboot.spring.javaconfig"})
@Configuration
public class SpringConfig {

	@Bean
	public UserDAO  getUserDAO(){
		  return new UserDAO()   ;
	}
	
	@Value("${jdbc.driverClass}")
	private String driverClass   ;
	
	@Value("${jdbc.jdbcUrl}")
	private String jdbcUrl   ;
	
	@Value("${jdbc.jdbcUsername}")
	private String jdbcUsername   ;
	
	@Value("${jdbc.jdbcPassword}")
	private String jdbcPassword   ;
	
	
	
	@Bean
	public DataSource  dataSource(){
		 BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
	        // 数据库驱动
	        boneCPDataSource.setDriverClass(driverClass);
	        // 相应驱动的jdbcUrl
	        boneCPDataSource.setJdbcUrl(jdbcUrl);
	        // 数据库的用户名
	        boneCPDataSource.setUsername(jdbcUsername);
	        // 数据库的密码
	        boneCPDataSource.setPassword(jdbcPassword);
	        // 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
	        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
	        // 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
	        boneCPDataSource.setIdleMaxAgeInMinutes(30);
	        // 每个分区最大的连接数
	        boneCPDataSource.setMaxConnectionsPerPartition(100);
	        // 每个分区最小的连接数    
	        boneCPDataSource.setMinConnectionsPerPartition(5);
	        return boneCPDataSource;
	}
	
	
	
}
