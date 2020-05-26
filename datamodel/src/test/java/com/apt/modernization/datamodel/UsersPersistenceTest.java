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
public class UsersPersistenceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(UsersPersistenceTest.class);
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Test
	public void testSimpleUsersPersistence() {
		removeAllUsersDocuments();
		
		LOG.debug("Starting Users-creation.....");
		Users users=new Users();
		users.setUser_id(1L); ;
		users.setFirst_name("FirstName");
		users.setLast_name("LastName");
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
	
	private Quotes buildSampleQuotes(int i, StringBuilder externalBuilder) {
		if (externalBuilder==null) {
			externalBuilder=new StringBuilder();
		}
		
		externalBuilder.setLength(0);
		externalBuilder.append("name-");
		externalBuilder.append(i);
		String insured=externalBuilder.toString();
		
		externalBuilder.setLength(0);
		externalBuilder.append("incept-");
		externalBuilder.append(i);
		String incept=externalBuilder.toString();
		
		externalBuilder.setLength(0);
		externalBuilder.append("expiry-");
		externalBuilder.append(i);
		String expiry=externalBuilder.toString();
		
		externalBuilder.setLength(0);
		externalBuilder.append("currency-");
		externalBuilder.append(i);
		String currency=externalBuilder.toString();
		
		return new Quotes(i, insured, incept, expiry, currency);
	}
	
	//
	// Nested classes
	//
	private static class Interval {
		private static final Logger LOG = LoggerFactory.getLogger(Interval.class);
		private static final long INTERVAL_INVALID=-1;
		
		private long start=INTERVAL_INVALID;
		private long end=INTERVAL_INVALID;
		
		public Interval() {
			start();
		}
		
		public void start() {
			start=System.currentTimeMillis();
			end=INTERVAL_INVALID;
		}
		
		public void stop() {
			if (start==INTERVAL_INVALID) {
				LOG.warn("Timng stopped without start. Forcing start resulting in a 0-interval.");
				start();
			}
			end=System.currentTimeMillis();
		}
		
		public long getInterval() {
			long result=INTERVAL_INVALID;
			if ((start!=INTERVAL_INVALID) && (end!=INTERVAL_INVALID))
			{
				result=end-start;
			}
			return result;
		}
		
		@Override
		public String toString() {
			return String.valueOf(getInterval());
		}
		
	}
}

