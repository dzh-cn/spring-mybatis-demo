package spring.mybatis;

import com.jd.absmall.entity.Product;
import com.jd.absmall.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * mybatis-spring
 *
 * @author: dongzhihua
 * @time: 2018/5/15 12:16:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/mybatis/applicationContext.xml")
public class TestMybatisSpring {

	private static Logger logger = LoggerFactory.getLogger(TestMybatisSpring.class);

	@Autowired
	ProductService productService;

	@Test
	public void testMain() {
		Product product = new Product();
		product.setProductId(1);
		product.setLastModifiedBy("dong");

		logger.info("TestMybatisSpring.testMain : {}", productService.updateProduct(product));
	}
}
