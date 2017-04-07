package org.noche.api;

import dto.LocationInfo;
import dto.PlaceInfo;
import org.noche.model.places.Place;
import org.noche.service.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Timi on 1/14/2017.
 */
@RestController
public class PlaceController {

    //api/.../{event} => pathVariable
    // api?name=bla  => request param
    // POST with entity JSON => request body

    /* --- Static members --- */

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceController.class);

    /* --- Members --- */

    @Autowired
    private PlaceService placeService;

    /* --- Public methods --- */

    @RequestMapping(value = "/save/{name}", method = RequestMethod.GET)
    public void savePlace(@PathVariable(value = "name") String name2) {
        Place place = new Place(name2);
        placeService.savePlace(place);
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public void savePlace2(@RequestParam(value = "name") String name) {
        Place place = new Place(name);
        placeService.savePlace(place);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void savePlace3(@RequestBody Place place) {
        placeService.savePlace(place);
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public PlaceInfo findPlaceByName(@RequestParam(value = "name") String name) {
        Place place = placeService.findByName(name);
        System.out.println(place.getName());
        return place.getInfo();
    }

    @RequestMapping(value = "/findPlacesByLocation", method = RequestMethod.POST)
    public Collection<PlaceInfo> findPlacesByLocation(@RequestBody LocationInfo locationInfo) {
        Collection<PlaceInfo> infos = new ArrayList<>();
        List<Place> places = placeService.findAllPlacesByCity(locationInfo.getCity());
        infos.addAll(places.stream().map(Place::getInfo).collect(Collectors.toList()));
        return infos;
    }


}
