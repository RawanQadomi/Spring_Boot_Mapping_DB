package com.seera.database.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "l1_services")
public class L1_Services {


    private String order_type;
    private String product_type;
    private Integer dim_group_id;

    private String order_no;
    private Integer dim_bookingdate_id;
    private Integer dim_store_id;
    private String ahs_group_name;
    private String product_name;
    private String product_code;
    private String dim_customer_id;
    private String dim_language;
    private String dim_totals_currency;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String phone;
    private Float payment_amount;
    private Float discount_amount;
    private Float base_amount;
    private Float inputvat;
    private Float outputvat;
    private Float product_vat;
    private Float selling_price;
    private Float selling_price_vat;
    private int conversion_rate_sar;
    private Float ibv;
    private Float gbv;

    private String service_fee_code;
    private Float iov_usd;
    private Float gbv_usd;

    private Float service_fee_amount;
 private Float conversion_rate_usd;
}
