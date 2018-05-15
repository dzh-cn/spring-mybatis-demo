package mybatis;

import com.baomidou.mybatisplus.MybatisSessionFactoryBuilder;
import com.baomidou.mybatisplus.toolkit.IOUtils;
import com.jd.absmall.mapper.ProductMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.HashSet;
import java.util.logging.Logger;

/**
 * mybatisXml demo
 *
 * @author: dongzhihua
 * @time: 2018/5/14 10:40:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mybatis/applicationContext.xml")
public class TestMybatisXml {

	private static Logger logger = Logger.getLogger(TestMybatisXml.class.getName());
	SqlSessionFactory ssf;

	private Collection<SqlSession> sqlSessions = new HashSet<>();

	@Before
	public void before() throws Exception {
		ssf = new MybatisSessionFactoryBuilder().build(new ClassPathResource("mybatis/mybatis-config.xml").getInputStream());
	}

	@After
	public void after() {
		for (SqlSession sqlSession : sqlSessions) {
			IOUtils.closeQuietly(sqlSession);
		}
		logger.info("TestMybatisXml.after : closed");
	}

	@Test
	public void main() throws InterruptedException {
		for (int i = 0; i < 5; i++)
			query();
	}

	void query() throws InterruptedException {
		SqlSession sqlSession = ssf.openSession();
		sqlSessions.add(sqlSession);
		ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
		Thread.sleep(2000);
		logger.warning("\t * " + productMapper.selectById(1));
	}
}