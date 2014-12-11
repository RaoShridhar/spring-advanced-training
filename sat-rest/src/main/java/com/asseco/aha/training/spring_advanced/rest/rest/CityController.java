package com.asseco.aha.training.spring_advanced.rest.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asseco.aha.training.spring_advanced.rest.domain.City;
import com.asseco.aha.training.spring_advanced.rest.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    /*
     * http://localhost:8080/city/, http://localhost:8080/city/?country=Spain, http://localhost:8080/city/?sorting=id
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<City> list(@PathParam("country") String country, @PathParam("sorting") String sorting) {
        return cityService.list(country, sorting);
    }

    /*
     * http://localhost:8080/city/105
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public City item(@PathVariable("id") long id) {
        return cityService.item(id);
    }
}