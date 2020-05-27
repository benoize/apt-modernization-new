package com.apt.modernization.datamodel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

	private static final long ID_BASIC_PERSISTENCE=1;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Test
	public void testSimpleUsersPersistence() {
		removeAllUsersDocuments();
		
		LOG.debug("Starting Users-creation.....");
		
		Users users=buildSampleUser(ID_BASIC_PERSISTENCE,null);
		Quotes quotes=buildSampleQuotes(ID_BASIC_PERSISTENCE, null);
		users.addUserQuote(quotes);
		usersRepository.save(users);
		
		LOG.debug("Users-creation finished.");
	}
	
	@Test
	public void testPersistenceRoundtrip() {
		removeAllUsersDocuments();
		
		LOG.debug("Starting Users-roundtrip.....");
		
		Users users=buildSampleUser(ID_BASIC_PERSISTENCE,null);
		Quotes quotes=buildSampleQuotes(ID_BASIC_PERSISTENCE, null);
		users.addUserQuote(quotes);
		usersRepository.save(users);
		
		Users fetchedUser=usersRepository.findById(ID_BASIC_PERSISTENCE);
		assertNotNull(fetchedUser,"Coud not read persisted users...");
		Quotes[] fetchedQuotes=fetchedUser.getUserQuotes();
		assertNotNull(fetchedQuotes,"Could not read quotes array. (null)");
		assertTrue(fetchedQuotes.length>0, "Could not read quotes array. (0)");
		
		LOG.debug("Users-roundtrip finished.");
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
	
	private Users buildSampleUser(long l, StringBuilder externalBuilder) {
		if (externalBuilder==null) {
			externalBuilder=new StringBuilder();
		}
		
		externalBuilder.setLength(0);
		externalBuilder.append("firstname-");
		externalBuilder.append(l);
		String firstname=externalBuilder.toString();
		
		externalBuilder.setLength(0);
		externalBuilder.append("lastname-");
		externalBuilder.append(l);
		String lastname=externalBuilder.toString();
		
		externalBuilder.setLength(0);
		externalBuilder.append("email-");
		externalBuilder.append(l);
		String email=externalBuilder.toString();
		
		Users users=new Users();
		users.setUserId(l);
		users.setFirstName(firstname);
		users.setLastName(lastname);
		users.setEmail(email);
		
		return users;
	}
}

