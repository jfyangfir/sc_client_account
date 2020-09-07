package com.jf.sc_client_account.service;


import com.jf.sc_client_account.entity.Country;

//default修饰方法只能在接口中使用，在接口中被default标记的方法为普通方法，可以直接写方法体
public interface CountryService {

    Country getCountryByCountryId(int countryId);

}
