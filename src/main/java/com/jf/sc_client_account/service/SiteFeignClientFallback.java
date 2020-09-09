package com.jf.sc_client_account.service;

import com.jf.sc_client_account.entity.City;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SiteFeignClientFallback implements SiteFeignClient {
    @Override
    public List<City> getCitiesById(int id) {
        return new ArrayList<City>();
    }
}
