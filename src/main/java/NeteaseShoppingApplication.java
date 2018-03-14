
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.netease"})
@MapperScan("com.netease.mapper")
public class NeteaseShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeteaseShoppingApplication.class, args);
	}
}
