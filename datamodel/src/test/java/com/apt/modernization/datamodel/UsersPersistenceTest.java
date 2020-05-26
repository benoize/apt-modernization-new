package com.apt.modernization.datamodel;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apt.modernization.datamodel.document.Quotes;
import com.apt.modernization.datamodel.document.Users;
import com.apt.modernization.datamodel.repository.UsersRepository;

@SpringBootTest
public class UsersPersistenceTest extends PersistenceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(UsersPersistenceTest.class);
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Test
	public void testSimpleUsersPersistence() {
		removeAllUsersDocuments();
		
		LOG.debug("Starting Users-creation.....");
		Users users=new Users();
		users.setUserId(1L); ;
		users.setFirstName("FirstName");
		users.setLastName("LastName");
		users.setEmail("Email");
		
		Quotes quotes=buildSampleQuotes(4711, null);
		users.addUserQuote(quotes);
		
		usersRepository.save(users);
		LOG.debug("Users-creation finished");
	}
	
	//
	// Utils
	//
	private void removeAllUsersDocuments() {
		LOG.debug("Removing Users-Documents...");
		Interval interval=new Interval();
		List<Users> userList=usersRepository.findAll();
		for (Users users:userList) {
			usersRepository.delete(users);
		}
		interval.stop();
		LOG.debug("Users-Documents are empty now. Took "+interval.getInterval()+"ms.");
	}
	
}

