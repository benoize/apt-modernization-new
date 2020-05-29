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
	private static final long ID_CONTAINER=1;
	private static final long ID_CHILD_LE=1;
	private static final long ID_CHILD_LR=2;
	private static final long ID_CHILD_E=3;
	private static final long ID_CHILD_R=4;
	
	@Autowired
	private ChildRepository referedRepository;
	@Autowired
	private ContainerRepository containerRepository;
	
	@Test
	public void testBasicReferences() {
		extinguishEcosystem();
		populateEcosystem();
		LOG.debug("Starting basic reference test.....");
		
		Child childViaParent1=getFirstChildViaParent(ID_CONTAINER);
		
		Child childDirect=referedRepository.findById(ID_CHILD_LR);
		childDirect.setName("modified-name");
		referedRepository.save(childDirect);

		Child childViaParent2=getFirstChildViaParent(ID_CONTAINER);
		
		assertEquals("child-"+ID_CHILD_LR, childViaParent1.getName());
		assertEquals("modified-name", childViaParent2.getName());
		
		LOG.debug("Finished basic reference test.");
	}

	//
	// Private stuff
	//
	private void extinguishEcosystem() {
		LOG.debug("Extinguishing ecosystem.....");
		List<Container> containerList=containerRepository.findAll();
		for (Container container:containerList) {
			containerRepository.delete(container);
		}
		List<Child> referedList=referedRepository.findAll();
		for (Child refered:referedList) {
			referedRepository.delete(refered);
		}
		LOG.debug("Ecosystem clear.");
	}
	private void populateEcosystem() {
		LOG.debug("Populating test ecosystem.....");
		Container container=buildSampleContainer(ID_CONTAINER, null);
		
		Child childListEmbedded=buildSampleChild(ID_CHILD_LE, null);
		container.addChildEmbedded(childListEmbedded);
		Child childListReferenced=buildSampleChild(ID_CHILD_LR, null);
		container.addChildReferenced(childListReferenced);
		
		Child embedded=buildSampleChild(ID_CHILD_E, null);
		container.setEmbedded(embedded);
		Child referenced=buildSampleChild(ID_CHILD_R, null);
		container.setReferenced(referenced);
		
		containerRepository.save(container);
		referedRepository.save(childListReferenced); // Must be saved separately, otherwise I couldnt retrieve it later on......
		referedRepository.save(referenced); // Must be saved separately, otherwise I couldnt retrieve it later on......
		LOG.debug("Ecosystem populated.");
	}
	
	private Child getFirstChildViaParent(long id) {
		Container readContainer=containerRepository.findById(id);
		assertNotNull(readContainer);
		Child[] readChildren=readContainer.getChildrenReferenced();
		assertNotNull(readChildren);
		assertTrue(readChildren.length>0);
		Child readRefered=readChildren[0];
		assertNotNull(readRefered);
		return readRefered;
	}
}
