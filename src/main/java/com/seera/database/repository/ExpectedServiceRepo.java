package com.seera.database.repository;

import com.seera.database.entity.L1_Services;
import com.seera.database.entity.L2_Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.security.PublicKey;
import java.util.List;

@Repository

public interface ExpectedServiceRepo extends JpaRepository<L1_Services, String> {
    @Query(value = "SELECT\n" +
            "\tls.order_type ,\n" +
            "\tls.product_type ,\n" +
            "\tls.dim_group_id,\n" +
            "\tls.order_no,\n" +
            "\tls.dim_bookingdate_id ,\n" +
            "\tls.dim_store_id ,\n" +
            "\tls.dim_customer_id,\n" +
            "\tls.dim_language,\n" +
            "\tls.dim_totals_currency,\n" +
            "\tls.dim_status_id ,\n" +
            "\tls.phone,\n" +
            "\tls.product_code,\n" +
            "\t'null' as 'service_fee_code',\n" +
            "\t0 as 'service_fee_amount',\n" +
            "\tls.product_name,\n" +
            "\tls.ahs_group_name,\n" +
            "\tls.payment_amount ,\n" +
            "\tls.discount_amount ,\n" +
            "\tls.base_amount,\n" +
            "\tls.inputvat,\n" +
            "\tls.outputvat,\n" +
            "\tls.product_vat,\n" +
            "\tls.conversion_rate_sar,\n" +
            "\tls.selling_price,\n" +
            "\tls.selling_price_vat,\n" +
            "\tls.conversion_rate_usd,\n" +
            "\tls.ibv,\n" +
            "\t(ls.ibv * ls.conversion_rate_usd) as 'iov_usd',\n" +
            "\tls.gbv,\n" +
            "\t(ls.gbv * ls.conversion_rate_usd) as 'gbv_usd'\n" +
            "from\n" +
            "\tl1_services ls where product_type != 'rule' GROUP by ls.order_no ;",nativeQuery = true)
    public List<L1_Services> getL1_serviceResultsInitial();

    @Query(value = "SELECT\n" +
            "\tls.order_type ,\n" +
            "\tls.product_type ,\n" +
            "\tls.dim_group_id,\n" +
            "\tls.order_no,\n" +
            "\tls.dim_bookingdate_id ,\n" +
            "\tls.dim_store_id ,\n" +
            "\tls.dim_customer_id,\n" +
            "\tls.dim_language,\n" +
            "\tls.dim_totals_currency,\n" +
            "\tls.dim_status_id ,\n" +
            "\tls.phone,\n" +
            "\tls.product_code,\n" +
            "\tls.product_code as 'service_fee_code',\n" +
            "\tls.selling_price as 'service_fee_amount',\n" +
            "\tls.product_name,\n" +
            "\tls.ahs_group_name,\n" +
            "\tls.payment_amount ,\n" +
            "\tls.discount_amount ,\n" +
            "\tls.base_amount,\n" +
            "\tls.inputvat,\n" +
            "\tls.outputvat,\n" +
            "\tls.product_vat,\n" +
            "\tls.conversion_rate_sar,\n" +
            "\tls.selling_price,\n" +
            "\tls.selling_price_vat,\n" +
            "\tls.conversion_rate_usd,\n" +
            "\tls.ibv,\n" +
            "\t(ls.ibv * ls.conversion_rate_usd) as 'iov_usd',\n" +
            "\tls.gbv,\n" +
            "\t(ls.gbv * ls.conversion_rate_usd) as 'gbv_usd'\n" +
            "from\n" +
            "\tl1_services ls where product_type = 'rule' GROUP by ls.order_no having\n" +
            "\tCOUNT(order_no) > 1;",nativeQuery = true)
    public List<L1_Services> getL1_serviceFee();

}
