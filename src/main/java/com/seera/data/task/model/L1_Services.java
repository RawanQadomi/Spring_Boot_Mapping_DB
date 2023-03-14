package com.seera.data.task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity(name = "l1_services")
public class L1_Services {

    @Id
    private String id;
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
    private String phone;
    private Integer payment_amount;
    private Integer discount_amount;
    private Integer base_amount;
    private Integer inputvat;
    private Integer outputvat;
    private Integer product_vat;
    private Integer selling_price;
    private Integer selling_price_vat;
    private Integer conversion_rate_sar;
    private Integer ibv;
    private Integer gbv;
    private Integer conversion_rate_usd;

    public Integer getBase_amount() {
        return base_amount;
    }

    public String getOrder_no() {
        return order_no;
    }

    public Integer getDim_bookingdate_id() {
        return dim_bookingdate_id;
    }

    public Integer getDim_group_id() {
        return dim_group_id;
    }

    public Integer getDim_store_id() {
        return dim_store_id;
    }

    public Integer getDiscount_amount() {
        return discount_amount;
    }

    public Integer getInputvat() {
        return inputvat;
    }

    public Integer getOutputvat() {
        return outputvat;
    }

    public Integer getPayment_amount() {
        return payment_amount;
    }

    public Integer getProduct_vat() {
        return product_vat;
    }

    public Integer getSelling_price() {
        return selling_price;
    }

    public String getAhs_group_name() {
        return ahs_group_name;
    }

    public Integer getConversion_rate_sar() {
        return conversion_rate_sar;
    }

    public String getDim_customer_id() {
        return dim_customer_id;
    }

    public String getDim_language() {
        return dim_language;
    }

    public Integer getSelling_price_vat() {
        return selling_price_vat;
    }

    public String getDim_totals_currency() {
        return dim_totals_currency;
    }

    public Integer getIbv() {
        return ibv;
    }

    public String getOrder_type() {
        return order_type;
    }

    public String getPhone() {
        return phone;
    }

    public String getProduct_code() {
        return product_code;
    }

    public Integer getGbv() {
        return gbv;
    }

    public Integer getConversion_rate_usd() {
        return conversion_rate_usd;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setAhs_group_name(String ahs_group_name) {
        this.ahs_group_name = ahs_group_name;
    }

    public void setBase_amount(Integer base_amount) {
        this.base_amount = base_amount;
    }

    public void setConversion_rate_sar(Integer conversion_rate_sar) {
        this.conversion_rate_sar = conversion_rate_sar;
    }

    public void setDim_bookingdate_id(Integer dim_bookingdate_id) {
        this.dim_bookingdate_id = dim_bookingdate_id;
    }

    public void setDim_customer_id(String dim_customer_id) {
        this.dim_customer_id = dim_customer_id;
    }

    public void setDim_group_id(Integer dim_group_id) {
        this.dim_group_id = dim_group_id;
    }

    public void setDim_language(String dim_language) {
        this.dim_language = dim_language;
    }

    public void setDim_store_id(Integer dim_store_id) {
        this.dim_store_id = dim_store_id;
    }

    public void setDim_totals_currency(String dim_totals_currency) {
        this.dim_totals_currency = dim_totals_currency;
    }

    public void setConversion_rate_usd(Integer conversion_rate_usd) {
        this.conversion_rate_usd = conversion_rate_usd;
    }

    public void setDiscount_amount(Integer discount_amount) {
        this.discount_amount = discount_amount;
    }

    public void setInputvat(Integer inputvat) {
        this.inputvat = inputvat;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public void setGbv(Integer gbv) {
        this.gbv = gbv;
    }

    public void setOutputvat(Integer outputvat) {
        this.outputvat = outputvat;
    }

    public void setPayment_amount(Integer payment_amount) {
        this.payment_amount = payment_amount;
    }

    public void setIbv(Integer ibv) {
        this.ibv = ibv;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public void setProduct_vat(Integer product_vat) {
        this.product_vat = product_vat;
    }

    public void setSelling_price(Integer selling_price) {
        this.selling_price = selling_price;
    }

    public void setSelling_price_vat(Integer selling_price_vat) {
        this.selling_price_vat = selling_price_vat;
    }
}
