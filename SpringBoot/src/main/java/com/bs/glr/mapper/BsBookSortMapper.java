package com.bs.glr.mapper;

import com.bs.glr.bean.BsBookSort;
import com.bs.glr.bean.BsBookSortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsBookSortMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_sort
     *
     * @mbg.generated
     */
    long countByExample(BsBookSortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_sort
     *
     * @mbg.generated
     */
    int deleteByExample(BsBookSortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_sort
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_sort
     *
     * @mbg.generated
     */
    int insert(BsBookSort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_sort
     *
     * @mbg.generated
     */
    int insertSelective(BsBookSort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_sort
     *
     * @mbg.generated
     */
    List<BsBookSort> selectByExample(BsBookSortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_sort
     *
     * @mbg.generated
     */
    BsBookSort selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_sort
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") BsBookSort record, @Param("example") BsBookSortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_sort
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") BsBookSort record, @Param("example") BsBookSortExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_sort
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(BsBookSort record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_sort
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(BsBookSort record);
}