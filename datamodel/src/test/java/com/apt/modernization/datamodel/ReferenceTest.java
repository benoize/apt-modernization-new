package com.apt.modernization.datamodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apt.modernization.datamodel.document.Child;
import com.apt.modernization.datamodel.document.Container;
import com.apt.modernization.datamodel.repository.ContainerRepository;
import com.apt.modernization.datamodel.repository.ChildRepository;

@SpringBootTest
public class ReferenceTest extends PersistenceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(UsersPersistenceTest.class);
	private static final long ID_BASIC_PERSISTENCE=1;
	
	@Autowired
	private ChildRepository referedRepository;
	@Autowired
	private ContainerRepository containerRepository;
	
	@Test
	public void testBasicReferences() {
		resetTestEcosystem();
		LOG.debug("Starting basic reference test.....");
		
		Container container=buildSampleReferenceContainer(ID_BASIC_PERSISTENCE, null);
		
		Child childListReferenced=buildSampleChild(ID_BASIC_PERSISTENCE, null);
		container.addChild(childListReferenced);
		
		Child embedded=buildSampleChild(ID_BASIC_PERSISTENCE+1, null);
		container.setEmbedded(embedded);
		Child referenced=buildSampleChild(ID_BASIC_PERSISTENCE+2, null);
		container.setReferenced(referenced);
		
		containerRepository.save(container);
		referedRepository.save(childListReferenced); // Must be saved separately, otherwise I couldnt retrieve it later on......
		referedRepository.save(referenced); // Must be saved separately, otherwise I couldnt retrieve it later on......
		
		Child childViaParent1=getFirstChildViaParent(ID_BASIC_PERSISTENCE);
		
		Child childDirect=referedRepository.findById(ID_BASIC_PERSISTENCE);
		childDirect.setName("modified-name");
		referedRepository.save(childDirect);

		Child childViaParent2=getFirstChildViaParent(ID_BASIC_PERSISTENCE);
		
		assertEquals("name-1", childViaParent1.getName());
		assertEquals("modified-name", childViaParent2.getName());
		
		
		LOG.debug("Finished basic reference test.");
	}

	//
	// Private stuff
	//
	private void resetTestEcosystem() {
		List<Container> containerList=containerRepository.findAll();
		for (Container container:containerList) {
			containerRepository.delete(container);
		}
		List<Child> referedList=referedRepository.findAll();
		for (Child refered:referedList) {
			referedRepository.delete(refered);
		}
	}
	
	private Child getFirstChildViaParent(long id) {
		Container readContainer=containerRepository.findById(id);
		assertNotNull(readContainer);
		Child[] readChildren=readContainer.getChildren();
		assertNotNull(readChildren);
		assertTrue(readChildren.length>0);
		Child readRefered=readChildren[0];
		assertNotNull(readRefered);
		return readRefered;
	}
}
