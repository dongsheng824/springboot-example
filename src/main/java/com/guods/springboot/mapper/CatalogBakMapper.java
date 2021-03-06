package com.guods.springboot.mapper;

import com.guods.springboot.model.CatalogBak;
import java.util.List;

public interface CatalogBakMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog_bak
     *
     * @mbggenerated Tue Nov 14 13:08:58 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog_bak
     *
     * @mbggenerated Tue Nov 14 13:08:58 CST 2017
     */
    int insert(CatalogBak record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog_bak
     *
     * @mbggenerated Tue Nov 14 13:08:58 CST 2017
     */
    CatalogBak selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog_bak
     *
     * @mbggenerated Tue Nov 14 13:08:58 CST 2017
     */
    List<CatalogBak> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog_bak
     *
     * @mbggenerated Tue Nov 14 13:08:58 CST 2017
     */
    int updateByPrimaryKey(CatalogBak record);
}