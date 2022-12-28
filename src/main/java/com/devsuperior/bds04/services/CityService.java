package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public CityDTO saveCity(CityDTO cityDto) {
        City city = new City();
        copyDtoToEntity(cityDto, city);
        city = cityRepository.save(city);
        return new CityDTO(city);
    }

    @Transactional(readOnly = true)
    public List<CityDTO> findAll(){
        List<City> list = cityRepository.findAll();
        return list.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
    }

    private void copyDtoToEntity(CityDTO cityDTO, City city) {

        city.setName(cityDTO.getName());
    }
}
