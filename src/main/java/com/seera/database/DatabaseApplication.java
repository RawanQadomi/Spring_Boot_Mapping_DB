package com.seera.database;

import com.seera.database.entity.L1_Services;
import com.seera.database.entity.L2_Services;
import com.seera.database.repository.ExpectedServiceRepo;
import com.seera.database.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import static org.aspectj.runtime.internal.Conversions.floatValue;


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

	private static ConfigurableApplicationContext ctx;
	public static void main(String[] args) {
		ctx = SpringApplication.run(DatabaseApplication.class, args);
		int exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
				// no errors
				return 0;
			}
		});
		System.exit(exitCode);
	}

	@PostConstruct
	@Test(groups = "regression")
	private void test(){
		l1_Services.addAll(expectedServiceRepo.getL1_serviceResultsInitial());
		services_fees.addAll(expectedServiceRepo.getL1_serviceFee());
        l2_Services.addAll(serviceRepo.findAll());
		expected_services.addAll(updateExpectedServices(l1_Services,services_fees));
		compareResults(expected_services,l2_Services);
		System.out.println("run is done");
	}

	private List<L1_Services> updateExpectedServices(List<L1_Services> l1_services_data, List<L1_Services> fee_services){
		for (int j = 0; j < fee_services.size(); j++) {
		for (int i = 0; i < l1_services_data.size(); i++) {
					if (l1_services_data.get(i).getOrder_no().equalsIgnoreCase(fee_services.get(j).getOrder_no()) ) {
						l1_services_data.get(i).setService_fee_code(fee_services.get(j).getProduct_code());
						l1_services_data.get(i).setService_fee_amount(fee_services.get(j).getSelling_price());
					}
			}
		}
		return l1_services_data;
		}

		private void compareResults(List<L1_Services> expected_services, List<L2_Services> actual_services){
			Assert.assertEquals(expected_services.size(),actual_services.size(), " Length of Expected and actual list are match ");
			for (int j = 0; j < actual_services.size(); j++) {
			for (int i = 0; i < expected_services.size(); i++) {
					if (expected_services.get(i).getOrder_no().equalsIgnoreCase(actual_services.get(j).getOrder_no()) ) {
                      Assert.assertEquals(expected_services.get(i).getOrder_type(),actual_services.get(j).getOrder_type(), " Order type is not match for "+expected_services.get(i).getOrder_no() );
                      Assert.assertEquals(expected_services.get(i).getDim_group_id().intValue(),  actual_services.get(j).getDim_group_id(), "getDim_group_id is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getDim_bookingdate_id().intValue(), actual_services.get(j).getDim_bookingdate_id(), "dim_bookingdate_id is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getDim_store_id().intValue(), actual_services.get(j).getDim_store_id(), "getDim_store_id is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getService_fee_code(),actual_services.get(j).getService_fee_code(), "getService_fee_code is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getDim_customer_id(),actual_services.get(j).getDim_customer_id(), "getDim_customer_id is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getDim_language(),actual_services.get(j).getDim_language(), "getDim_language is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getDim_totals_currency(),actual_services.get(j).getDim_totals_currency(), "getDim_totals_currency is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getDim_store_id().intValue(),actual_services.get(j).getDim_store_id(), "getDim_store_id is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getPhone(),actual_services.get(j).getPhone(), "getPhone is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getPayment_amount().floatValue(), actual_services.get(j).getPayment_amount().floatValue(), "getPayment_amount is not match for expected "+ expected_services.get(i).getPayment_amount() +"actual is "+Float.valueOf(actual_services.get(i).getPayment_amount())+"for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getDiscount_amount().floatValue(), actual_services.get(j).getDiscount_amount().floatValue(), "getDiscount_amount is not match for "+expected_services.get(i).getOrder_no());
					  Assert.assertEquals(expected_services.get(i).getService_fee_amount().floatValue(), actual_services.get(j).getService_fee_amount().floatValue(), "getService_fee_amount is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getBase_amount().floatValue(), actual_services.get(j).getBase_amount().floatValue(), "getBase_amount is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getInputvat().floatValue(), actual_services.get(j).getInputvat().floatValue(), "getInputvat is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getOutputvat().floatValue(), actual_services.get(j).getOutputvat().floatValue(), "getOutputvat is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getProduct_vat().floatValue(), actual_services.get(j).getProduct_vat().floatValue(), "getProduct_vat is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getSelling_price().floatValue(),actual_services.get(j).getSelling_price().floatValue(), "getSelling_price is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getSelling_price_vat().floatValue(), actual_services.get(j).getSelling_price_vat().floatValue(), "getSelling_price_vat is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getIbv().floatValue(), actual_services.get(j).getIbv().floatValue(), "getIbv is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getIov_usd().floatValue(),(actual_services.get(j).getIov_used() == null? floatValue(0.0): actual_services.get(j).getIov_used().floatValue()), "getIov_usd is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getGbv().floatValue(), actual_services.get(j).getGbv().floatValue(), "getGbv is not match for "+expected_services.get(i).getOrder_no());
                      Assert.assertEquals(expected_services.get(i).getGbv_usd().floatValue(), (actual_services.get(j).getGbv_used() == null?  floatValue(0.0): actual_services.get(j).getGbv_used().floatValue()), "getGbv_used is not match for "+expected_services.get(i).getOrder_no());
					}
				}

			}
		}
}
