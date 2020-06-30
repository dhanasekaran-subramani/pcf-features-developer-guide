package com.ds2.pcf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OracleHomeController
{
    @Autowired
    OracleService oracleService;

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public ResponseEntity<RestResponse<List<Map<String, Object>>>> homePage(){

        return generateSuccessfulRestResponse(oracleService.getAllMessages());
    }

    protected <T> ResponseEntity<RestResponse<T>> generateSuccessfulRestResponse(final T subject) {
        final RestResponse<T> restResponse = new RestResponse<>();
        restResponse.setSubject(subject);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).cacheControl(CacheControl.noCache())
                .body(restResponse);
    }
}
