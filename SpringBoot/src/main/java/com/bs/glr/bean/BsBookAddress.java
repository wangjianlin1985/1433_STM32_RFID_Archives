package com.bs.glr.bean;

public class BsBookAddress {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_book_address.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_book_address.address_name
     *
     * @mbg.generated
     */
    private String addressName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_book_address.id
     *
     * @return the value of bs_book_address.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_book_address.id
     *
     * @param id the value for bs_book_address.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_book_address.address_name
     *
     * @return the value of bs_book_address.address_name
     *
     * @mbg.generated
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_book_address.address_name
     *
     * @param addressName the value for bs_book_address.address_name
     *
     * @mbg.generated
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }
}