package com.bs.glr.bean;

public class BsBookSort {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_book_sort.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_book_sort.sort_name
     *
     * @mbg.generated
     */
    private String sortName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_book_sort.id
     *
     * @return the value of bs_book_sort.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_book_sort.id
     *
     * @param id the value for bs_book_sort.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_book_sort.sort_name
     *
     * @return the value of bs_book_sort.sort_name
     *
     * @mbg.generated
     */
    public String getSortName() {
        return sortName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_book_sort.sort_name
     *
     * @param sortName the value for bs_book_sort.sort_name
     *
     * @mbg.generated
     */
    public void setSortName(String sortName) {
        this.sortName = sortName == null ? null : sortName.trim();
    }
}