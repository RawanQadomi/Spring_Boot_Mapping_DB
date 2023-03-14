package com.seera.data.task;


import com.seera.data.task.model.L1_Services;
import com.seera.data.task.model.L2_Services;
import com.seera.data.task.service.L1_servicesRepository;
import com.seera.data.task.service.L2_servicesRepository;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


//@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class TaskApplicationTests{
//		extends AbstractTestNGSpringContextTests {


    @Autowired
	private L2_servicesRepository l2_servicesRepository;
	@Autowired
	private L1_servicesRepository l1_servicesRepository;
	List<L2_Services> l2_Services = new ArrayList<>();
	List<L1_Services> l2_ServicesExpect = new ArrayList<>();



	private void show(List<L2_Services> l2_Services) {
		l2_Services.forEach(System.out::println);
	}
	@Test
	public void testGetOrders()  {
		l2_ServicesExpect = l1_servicesRepository.getL2_serviceResultsInitial();
		l2_Services = l2_servicesRepository.getL2_serviceResults();
		show(l2_Services);
//		Assert.assertEquals(l2_Services,l2_ServicesExpect);
	}

}
