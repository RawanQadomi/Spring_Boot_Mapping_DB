package com.seera.data.task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import lombok.Builder;


@Entity(name = "l2_services")
public class L2_Services {

    @Id
    private String id;
     private String order_type;
    private String product_type;
    private Integer dim_group_id;
    private String order_no;
    private Integer dim_bookingdate_id;
    private Integer dim_store_id;
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
    private Integer iov_used;
    private Integer gbv;
    private Integer gbv_used;

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public void setDim_store_id(Integer dim_store_id) {
        this.dim_store_id = dim_store_id;
    }

    public void setDim_language(String dim_language) {
        this.dim_language = dim_language;
    }

    public void setDim_group_id(Integer dim_group_id) {
        this.dim_group_id = dim_group_id;
    }

    public void setDim_customer_id(String dim_customer_id) {
        this.dim_customer_id = dim_customer_id;
    }

    public void setDim_bookingdate_id(Integer dim_bookingdate_id) {
        this.dim_bookingdate_id = dim_bookingdate_id;
    }

    public void setSelling_price(Integer selling_price) {
        this.selling_price = selling_price;
    }

    public void setProduct_vat(Integer product_vat) {
        this.product_vat = product_vat;
    }

    public void setSelling_price_vat(Integer selling_price_vat) {
        this.selling_price_vat = selling_price_vat;
    }

    public void setPayment_amount(Integer payment_amount) {
        this.payment_amount = payment_amount;
    }

    public void setOutputvat(Integer outputvat) {
        this.outputvat = outputvat;
    }

    public void setDim_totals_currency(String dim_totals_currency) {
        this.dim_totals_currency = dim_totals_currency;
    }

    public void setInputvat(Integer inputvat) {
        this.inputvat = inputvat;
    }

    public void setDiscount_amount(Integer discount_amount) {
        this.discount_amount = discount_amount;
    }

    public void setBase_amount(Integer base_amount) {
        this.base_amount = base_amount;
    }

    public void setIbv(Integer ibv) {
        this.ibv = ibv;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGbv(Integer gbv) {
        this.gbv = gbv;
    }

    public void setDim_status_id(String dim_status_id) {
        this.dim_status_id = dim_status_id;
    }

    public void setGbv_used(Integer gbv_used) {
        this.gbv_used = gbv_used;
    }

    public void setIov_used(Integer iov_used) {
        this.iov_used = iov_used;
    }

    public void setService_fee_amount(Integer service_fee_amount) {
        this.service_fee_amount = service_fee_amount;
    }

    public void setService_fee_code(String service_fee_code) {
        this.service_fee_code = service_fee_code;
    }

    public String getProduct_type() {
        return product_type;
    }

    public String getProduct_code() {
        return product_code;
    }

    public String getPhone() {
        return phone;
    }

    public String getOrder_type() {
        return order_type;
    }

    public String getDim_totals_currency() {
        return dim_totals_currency;
    }

    public String getDim_language() {
        return dim_language;
    }

    public String getDim_customer_id() {
        return dim_customer_id;
    }

    public Integer getPayment_amount() {
        return payment_amount;
    }

    public Integer getDim_store_id() {
        return dim_store_id;
    }

    public Integer getDiscount_amount() {
        return discount_amount;
    }

    public Integer getDim_group_id() {
        return dim_group_id;
    }

    public Integer getDim_bookingdate_id() {
        return dim_bookingdate_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public Integer getGbv() {
        return gbv;
    }

    public String getDim_status_id() {
        return dim_status_id;
    }

    public Integer getIbv() {
        return ibv;
    }

    public Integer getSelling_price_vat() {
        return selling_price_vat;
    }

    public Integer getService_fee_amount() {
        return service_fee_amount;
    }

    public Integer getBase_amount() {
        return base_amount;
    }

    public Integer getInputvat() {
        return inputvat;
    }

    public Integer getSelling_price() {
        return selling_price;
    }

    public Integer getProduct_vat() {
        return product_vat;
    }

    public Integer getOutputvat() {
        return outputvat;
    }

    public Integer getGbv_used() {
        return gbv_used;
    }

    public String getService_fee_code() {
        return service_fee_code;
    }

    public Integer getIov_used() {
        return iov_used;
    }

}
