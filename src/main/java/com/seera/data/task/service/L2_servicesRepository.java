package com.seera.data.task.service;
import com.seera.data.task.model.L2_Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface L2_servicesRepository  extends JpaRepository<L2_Services, String> {

    @Query(value = "SELECT\n" +
            "\torder_type,\n" +
            "\tdim_group_id,\n" +
            "\torder_no,\n" +
            "\tdim_bookingdate_id,\n" +
            "\tdim_store_id,\n" +
//            "\tservice_fee_code,\n" +
            "\tdim_customer_id,\n" +
            "\tdim_language,\n" +
            "\tdim_totals_currency,\n" +
            "\tdim_status_id,\n" +
            "\tphone,\n" +
            "\tpayment_amount,\n" +
            "\tdiscount_amount,\n" +
//            "\tservice_fee_amount,\n" +
            "\tbase_amount,\n" +
            "\tinputvat,\n" +
            "\toutputvat,\n" +
            "\tproduct_vat,\n" +
            "\tselling_price,\n" +
            "\tselling_price_vat,\n" +
            "\tibv,\n" +
            "\tiov_usd,\n" +
            "\tgbv,\n" +
            "\tgbv_usd\n" +
            "from\n" +
            "\tl2_services ls",nativeQuery = true)
    public List<L2_Services> getL2_serviceResults();

}
