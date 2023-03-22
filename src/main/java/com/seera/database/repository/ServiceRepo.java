package com.seera.database.repository;


import com.seera.database.entity.L2_Services;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepo extends JpaRepository<L2_Services, String> {

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
            "\tservice_fee_code,\n" +
            "\tservice_fee_amount,\n" +
            "\tls.payment_amount ,\n" +
            "\tls.discount_amount ,\n" +
            "\tls.base_amount,\n" +
            "\tls.inputvat,\n" +
            "\tls.outputvat,\n" +
            "\tls.product_vat,\n" +
            "\tls.selling_price,\n" +
            "\tls.selling_price_vat,\n" +
            "\tls.ibv,\n" +
            "\tiov_usd,\n" +
            "\tls.gbv,\n" +
            "\tgbv_usd\n" +
            "from\n" +
            "\tl2_services ls GROUP by ls.order_no ;",nativeQuery = true)
    public List<L2_Services> findAll();
}
