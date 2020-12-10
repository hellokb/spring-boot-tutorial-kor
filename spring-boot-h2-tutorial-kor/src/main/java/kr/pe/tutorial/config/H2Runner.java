package kr.pe.tutorial.config;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class H2Runner implements ApplicationRunner{
	private static final Logger log = LoggerFactory.getLogger(H2Runner.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try(Connection connection = dataSource.getConnection()) {
			log.info("===== h2 url =====");
			log.info(connection.getMetaData().getURL());
			log.info("===== h2 username =====");
			log.info(connection.getMetaData().getUserName());
			
			Statement statement = connection.createStatement();
			String sql = "CREATE TABLE POKEMON(ID INTEGER NOT NULL, NAME VARCHAR(255), PRIMARY KEY(ID))";
			statement.executeUpdate(sql);
			
			jdbcTemplate.execute("INSERT INTO POKEMON VALUES(1, '이상해씨')");
		}
	}
	
}
