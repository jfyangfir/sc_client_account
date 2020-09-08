package com.jf.sc_client_account.service.serviceImpl;

import com.jf.sc_client_account.dao.CountryDao;
import com.jf.sc_client_account.entity.City;
import com.jf.sc_client_account.entity.Country;
import com.jf.sc_client_account.service.CountryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

        @Autowired
        private CountryDao countryDao;

        @Autowired
        private RestTemplate restTemplate;

        //如果没有请求到微服务，就调用fallbackMethod里面的方法
        @HystrixCommand(fallbackMethod = "getCountryByUserIdFallback")
        public Country getCountryByCountryId(int countryId) {
            Country country= countryDao.getCountryByCountryId(countryId);
            List<City> cities=restTemplate.getForObject("http://CLIENT-SITE/api/cities/{cityId}",List.class,7);
            country.setCities(cities);
            return country;
        }

        public Country getCountryByUserIdFallback(int countryId){
            Country country = countryDao.getCountryByCountryId(countryId);
            country.setCities(new ArrayList<City>());
            return country;
        }



}
