package com.guods.springboot.mapper;

import com.guods.springboot.model.Catalog;
import java.util.List;

public interface CatalogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog
     *
     * @mbggenerated Tue Nov 14 13:08:58 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog
     *
     * @mbggenerated Tue Nov 14 13:08:58 CST 2017
     */
    int insert(Catalog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog
     *
     * @mbggenerated Tue Nov 14 13:08:58 CST 2017
     */
    Catalog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog
     *
     * @mbggenerated Tue Nov 14 13:08:58 CST 2017
     */
    List<Catalog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catalog
     *
     * @mbggenerated Tue Nov 14 13:08:58 CST 2017
     */
    int updateByPrimaryKey(Catalog record);
}