package com.jf.sc_client_account.dao;

import com.jf.sc_client_account.entity.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CountryDao {

    @Select("select * from country where countryId=#{countryId}")
    Country getCountryByCountryId(int countryId);

}
