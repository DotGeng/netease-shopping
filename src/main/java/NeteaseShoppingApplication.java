
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
@ComponentScan(basePackages = {"com.netease"})
@MapperScan("com.netease.mapper")
public class NeteaseShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeteaseShoppingApplication.class, args);
	}
}
