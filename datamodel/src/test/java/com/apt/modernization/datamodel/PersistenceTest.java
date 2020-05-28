package com.apt.modernization.datamodel;

import com.apt.modernization.datamodel.document.Quotes;
import com.apt.modernization.datamodel.document.Users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersistenceTest {
	
	protected Quotes buildSampleQuotes(long l, StringBuilder externalBuilder) {
		if (externalBuilder==null) {
			externalBuilder=new StringBuilder();
		}
		
		externalBuilder.setLength(0);
		externalBuilder.append("name-");
		externalBuilder.append(l);
		String insured=externalBuilder.toString();
		
		externalBuilder.setLength(0);
		externalBuilder.append("incept-");
		externalBuilder.append(l);
		String incept=externalBuilder.toString();
		
		externalBuilder.setLength(0);
		externalBuilder.append("expiry-");
		externalBuilder.append(l);
		String expiry=externalBuilder.toString();
		
		externalBuilder.setLength(0);
		externalBuilder.append("currency-");
		externalBuilder.append(l);
		String currency=externalBuilder.toString();
		
		Quotes result=new Quotes(l);
		result.setInsuredName(insured);
		result.setInceptDate(incept);
		result.setExpiryDate(expiry);
		result.setCurrency(currency);
		return result;
	}
	
	protected Users buildSampleUser(long l, StringBuilder externalBuilder) {
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
		
		Users users=new Users(l);
		users.setFirstName(firstname);
		users.setLastName(lastname);
		users.setEmail(email);
		
		return users;
	}
	
	//
	// Nested classes
	//
	protected static class Interval {
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
				LOG.warn("Interval stopped without start. Forcing start resulting in a 0-interval.");
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
