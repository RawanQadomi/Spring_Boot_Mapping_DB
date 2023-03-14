package com.seera.database.entity;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "l2_services")
public class L2_Services {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String order_type;
    private String product_type;
    private Integer dim_group_id;
    private String order_no;
    private int dim_bookingdate_id;
    private int dim_store_id;
    private String service_fee_code;
    private String product_code;
    private String dim_customer_id;
    private String dim_language;
    private String dim_totals_currency;

    private String dim_status_id;
    private String phone;

    private Integer payment_amount;
    private Integer discount_amount;
    private Integer service_fee_amount;
    private Integer base_amount;

    private Integer inputvat;
    private Integer outputvat;
    private Integer product_vat;

    private Integer selling_price;
    private Integer selling_price_vat;
    private Integer ibv;
    private Double iov_used;
    private Integer gbv;
    private Double gbv_used;
}
