package com.seera.data.task.service;

import com.seera.data.task.model.L1_Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface L1_servicesRepository  extends JpaRepository<L1_Services, String> {
    @Query(value = " SELECT\n" +
            "\tls.order_type ,\n" +
            "\tls.dim_group_id,\n" +
            "\tls.order_no,\n" +
            "\tls.dim_bookingdate_id ,\n" +
            "\tls.dim_store_id ,\n" +
            "\tls.dim_customer_id,\n" +
            "\tls.dim_language,\n" +
            "\tls.dim_totals_currency,\n" +
            "\tls.dim_status_id ,\n" +
            "\tls.phone,\n" +
            "\tls.payment_amount ,\n" +
            "\tls.discount_amount ,\n" +
            "\tls.base_amount,\n" +
            "\tls.inputvat,\n" +
            "\tls.outputvat,\n" +
            "\tls.product_vat,\n" +
            "\tls.selling_price,\n" +
            "\tls.selling_price_vat,\n" +
            "\tls.ibv,\n" +
            "\t(ls.ibv * ls.conversion_rate_usd) as 'iov_usd',\n" +
            "\tls.gbv,\n" +
            "\t(ls.gbv * ls.conversion_rate_usd) as 'gbv_usd'\n" +
            "from\n" +
            "\tl1_services ls where ls.order_type = ls.product_type GROUP by order_no ",nativeQuery = true)
    public List<L1_Services> getL2_serviceResultsInitial();

    @Query(value = "SELECT\n" +
            "\tls.order_no ,\n" +
            "\t\tWHEN ls.order_no in (\n" +
            "\t\tselect\n" +
            "\t\t\torder_no\n" +
            "\t\tfrom\n" +
            "\t\t\tl1_services ls3\n" +
            "\t\tWHERE\n" +
            "\t\t\tls3.product_type = 'rule'\n" +
            "\t\tGROUP by\n" +
            "\t\t\tls3.order_no\n" +
            "\t\tHAVING\n" +
            "\t\t\tcount(order_no) > 1 ) THEN ls.product_code\n" +
            "\t\tELSE 'null'\n" +
            "\tEND as 'service_fee_code'\n" +
            "\t\n" +
            "from\n" +
            "\tl1_services ls\n" +
            "group by\n" +
            "\torder_no\n" +
            "\torder by  product_type,\n" +
            "\torder_type ;\n", nativeQuery = true)
    public List<L1_Services> getServiceFeesResult();

    @Query(value="SELECT\n" +
            "\t case\n" +
            "\t\tWHEN ls.order_no in (\n" +
            "\t\tselect\n" +
            "\t\t\torder_no\n" +
            "\t\tfrom\n" +
            "\t\t\tl1_services ls3\n" +
            "\t\tWHERE\n" +
            "\t\t\tls3.product_type = 'rule'\n" +
            "\t\tGROUP by\n" +
            "\t\t\tls3.order_no\n" +
            "\t\tHAVING\n" +
            "\t\t\tcount(order_no) > 1 ) THEN selling_price\n" +
            "\t\tELSE 0\n" +
            "\tEND as 'service_fee_amount'\n" +
            "from\n" +
            "\tl1_services ls\n" +
            "group by\n" +
            "\torder_no\n" +
            "\torder by  product_type,\n" +
            "\torder_type ;", nativeQuery = true)
    public List<L1_Services> getServiceAmountFees();

    @Query(value="SELECT\n" +
            "\torder_no,\n" +
            "\tselling_price ,\n" +
            "\tproduct_code\n" +
            "from\n" +
            "\tl1_services ls\n" +
            "where\n" +
            "\tproduct_type = 'rule'", nativeQuery = true)
    public List<L1_Services> getServiceFees();

}
