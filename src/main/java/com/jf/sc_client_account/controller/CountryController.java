package com.jf.sc_client_account.controller;

import com.jf.sc_client_account.entity.Country;
import com.jf.sc_client_account.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryService countryService;

    /*
     * http://127.0.0.1:8762/api/country/3
     * */
    /** @PathVariable 找路径上面对应的参数
     * @RequestParam 将请求参数绑定到你控制器的方法参数上
     */

    @RequestMapping("/country/{countryId}")
    public Country getCountryByCountryId(@PathVariable int countryId) {
        return countryService.getCountryByCountryId(countryId);
    }
}
