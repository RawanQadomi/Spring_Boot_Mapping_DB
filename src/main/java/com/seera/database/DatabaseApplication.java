package com.seera.database;

import com.seera.database.entity.L1_Services;
import com.seera.database.entity.L2_Services;
import com.seera.database.repository.ExpectedServiceRepo;
import com.seera.database.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@EnableJpaRepositories
@SpringBootApplication
public class DatabaseApplication {


	@Autowired
	ServiceRepo serviceRepo;
	@Autowired
	ExpectedServiceRepo expectedServiceRepo;
	List<L2_Services>  l2_Services = new ArrayList<>();
	List<L1_Services>  l1_Services= new ArrayList<>();
	List<L1_Services> services_fees = new ArrayList<>();
	List<L1_Services> expected_services = new ArrayList<>();
	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}



	@PostConstruct
	private void test(){
		System.out.printf("hi");
//		 serviceRepo.findAll().forEach(System.out::println);
		l1_Services.addAll(expectedServiceRepo.getL1_serviceResultsInitial());
//		expectedServiceRepo.getL1_serviceResultsInitial().forEach(System.out::println);
		services_fees.addAll(expectedServiceRepo.getL1_serviceFee());
       l2_Services.addAll(serviceRepo.findAll());
		expected_services.addAll(updateExpectedServices(l1_Services,services_fees));
//		expected_service = updateExpectedServices(l1_Services);
//		expected_service.forEach(System.out::println);

	}

	private List<L1_Services> updateExpectedServices(List<L1_Services> l1_services_data, List<L1_Services> fee_services){
		for (int j = 0; j < fee_services.size(); j++) {
		for (int i = 0; i < l1_services_data.size(); i++) {
					if (l1_services_data.get(i).getOrder_no().equalsIgnoreCase(fee_services.get(j).getOrder_no()) ) {
						l1_services_data.get(i).setService_fee_code(fee_services.get(j).getProduct_code());
						l1_services_data.get(j).setService_fee_amount(fee_services.get(j).getSelling_price());

					}
			}
		}
		return l1_services_data;
		}

		private void compareResults(List<L1_Services> expected_services, List<L1_Services> actual_services){
			for (int i = 0; i < expected_services.size(); i++) {
				for (int j = 0; j < actual_services.size(); j++) {
					if (expected_services.get(i).getOrder_no().equalsIgnoreCase(expected_services.get(j).getOrder_no()) ) {

					}
				}

			}
		}


}
