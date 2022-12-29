package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Transactional
    public EventDTO saveEvent(EventDTO eventDTO) {
        Event event = new Event();
        copyDtoToEntity(eventDTO, event);
        event = eventRepository.save(event);
        return new EventDTO(event);
    }

    @Transactional(readOnly = true)
    public Page<EventDTO> findAllPaged(Pageable pageable){
        Page<Event> list = eventRepository.findAll(pageable);
        return list.map(x -> new EventDTO(x));
    }

    private void copyDtoToEntity(EventDTO eventDTO, Event event) {

        event.setCity(new City(eventDTO.getCityId(), null));
        event.setName(eventDTO.getName());
        event.setDate(eventDTO.getDate());
        event.setUrl(eventDTO.getUrl());
    }
}
