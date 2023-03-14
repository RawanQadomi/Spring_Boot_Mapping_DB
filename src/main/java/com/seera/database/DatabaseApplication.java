package com.seera.database;

import com.seera.database.entity.L1_Services;
import com.seera.database.entity.L2_Services;
import com.seera.database.repository.ExpectedServiceRepo;
import com.seera.database.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.Assert;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.PostConstruct;


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
		l1_Services.addAll(expectedServiceRepo.getL1_serviceResultsInitial());
		services_fees.addAll(expectedServiceRepo.getL1_serviceFee());
       l2_Services.addAll(serviceRepo.findAll());
		expected_services.addAll(updateExpectedServices(l1_Services,services_fees));
		compareResults(expected_services,l2_Services);
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

		private void compareResults(List<L1_Services> expected_services, List<L2_Services> actual_services){
			for (int j = 0; j < actual_services.size(); j++) {
			for (int i = 0; i < expected_services.size(); i++) {
					if (expected_services.get(i).getOrder_no().equalsIgnoreCase(actual_services.get(j).getOrder_no()) ) {
                      Assert.isTrue(expected_services.get(i).getOrder_type().equalsIgnoreCase(actual_services.get(j).getOrder_type()), " Order type is not match for "+expected_services.get(i).getOrder_no() +"  "+expected_services.get(i).getOrder_type()+"  "+actual_services.get(j).getOrder_type() );
                      Assert.isTrue(expected_services.get(i).getDim_group_id() ==  actual_services.get(j).getDim_group_id(), "getDim_group_id is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getDim_bookingdate_id() == actual_services.get(j).getDim_bookingdate_id(), "dim_bookingdate_id is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getDim_store_id()== actual_services.get(j).getDim_store_id(), "getDim_store_id is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getService_fee_code().equalsIgnoreCase(actual_services.get(j).getService_fee_code()), "getService_fee_code is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getDim_customer_id().equalsIgnoreCase(actual_services.get(j).getDim_customer_id()), "getDim_customer_id is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getDim_language().equalsIgnoreCase(actual_services.get(j).getDim_language()), "getDim_language is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getDim_totals_currency().equalsIgnoreCase(actual_services.get(j).getDim_totals_currency()), "getDim_totals_currency is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getDim_store_id() ==actual_services.get(j).getDim_store_id(), "getDim_store_id is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getPhone().equalsIgnoreCase(actual_services.get(j).getPhone()), "getPhone is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getPayment_amount()== actual_services.get(j).getPayment_amount().floatValue(), "getPayment_amount is not match for expected "+ expected_services.get(i).getPayment_amount() +"actual is "+Float.valueOf(actual_services.get(i).getPayment_amount())+"for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getDiscount_amount() == actual_services.get(j).getDiscount_amount().floatValue(), "getDiscount_amount is not match for "+expected_services.get(i).getOrder_no());
//                      Assert.isTrue(expected_services.get(i).getService_fee_amount() == actual_services.get(j).getService_fee_amount().floatValue(), "getService_fee_amount is not match for "+expected_services.get(i).getOrder_no()+" actual is "+actual_services.get(j).getService_fee_amount().floatValue()+" for "+expected_services.get(i).getService_fee_amount().floatValue());
                      Assert.isTrue(expected_services.get(i).getBase_amount() == actual_services.get(j).getBase_amount().floatValue(), "getBase_amount is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getInputvat() == actual_services.get(j).getInputvat().floatValue(), "getInputvat is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getOutputvat() == actual_services.get(j).getOutputvat().floatValue(), "getOutputvat is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getProduct_vat() == actual_services.get(j).getProduct_vat().floatValue(), "getProduct_vat is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getSelling_price() ==actual_services.get(j).getSelling_price().floatValue(), "getSelling_price is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getSelling_price_vat() == actual_services.get(j).getSelling_price_vat().floatValue(), "getSelling_price_vat is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getIbv() == actual_services.get(j).getIbv().floatValue(), "getIbv is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getIov_usd() == (actual_services.get(j).getIov_used() == null? 0.0: actual_services.get(j).getIov_used().floatValue()), "getIov_usd is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getGbv() == actual_services.get(j).getGbv().floatValue(), "getGbv is not match for "+expected_services.get(i).getOrder_no());
                      Assert.isTrue(expected_services.get(i).getGbv_usd() == (actual_services.get(j).getGbv_used() == null? 0.0: actual_services.get(j).getGbv_used().floatValue()), "getGbv_used is not match for "+expected_services.get(i).getOrder_no());
					}
				}

			}
		}


}
