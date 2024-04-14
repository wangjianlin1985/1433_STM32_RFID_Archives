package com.bs.glr.mapper;

import com.bs.glr.bean.BsBookInfo;
import com.bs.glr.bean.BsBookInfoExample;
import java.util.List;
import java.util.Map;

import com.bs.glr.bean.EchartBean;
import org.apache.ibatis.annotations.Param;

public interface BsBookInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_info
     *
     * @mbg.generated
     */
    long countByExample(BsBookInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_info
     *
     * @mbg.generated
     */
    int deleteByExample(BsBookInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_info
     *
     * @mbg.generated
     */
    int insert(BsBookInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_info
     *
     * @mbg.generated
     */
    int insertSelective(BsBookInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_info
     *
     * @mbg.generated
     */
    List<BsBookInfo> selectByExample(BsBookInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_info
     *
     * @mbg.generated
     */
    BsBookInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_info
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") BsBookInfo record, @Param("example") BsBookInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_info
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") BsBookInfo record, @Param("example") BsBookInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(BsBookInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_book_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(BsBookInfo record);
    List<EchartBean> getBookTypeInfoChart();

    List<EchartBean> getBootCountChart();

    List<EchartBean> getBookTypeInfoChartByUid(Map<String,Integer> map);

    List<EchartBean> getBootCountChartByUid(Map<String,String> map);
}