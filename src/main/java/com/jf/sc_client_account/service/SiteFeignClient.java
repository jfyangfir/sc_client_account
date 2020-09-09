package com.jf.sc_client_account.service;

import com.jf.sc_client_account.entity.City;
import com.jf.sc_client_account.entity.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "CLIENT-SITE",fallback = SiteFeignClientFallback.class)
public interface SiteFeignClient {

    @RequestMapping("/api/cities/{id}")
    List<City> getCitiesById(@PathVariable int id);
}
