package com.learn.portal.service.implementation;

import com.learn.portal.dto.EventsDto;
import com.learn.portal.entites.Events;
import com.learn.portal.repository.EventsRepository;
import com.learn.portal.service.EventsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {
    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public EventsDto createEvents(EventsDto eventsDto) {
        Events events = new Events();
        events.setEventsTitle(eventsDto.getEventsTitle());
        events.setEventsDescription(eventsDto.getEventsDescription());
        events.setEventsDate(eventsDto.getEventsDate());
        events.setEventImage(eventsDto.getEventImage());
        eventsRepository.save(events);
        return eventsDto;

    }

    @Override
    public List<EventsDto> getEvents() {
        EventsDto eventsDto = new EventsDto();
        List<Events> events = eventsRepository.findAll();
        return this.modelMapper.map(events, List.class);
    }

    @Override
    public EventsDto updateEvents(int eventsId, EventsDto eventsDto) {
        Events events = eventsRepository.findById(eventsId).get();
        events.setEventsTitle(eventsDto.getEventsTitle());
        events.setEventsDescription(eventsDto.getEventsDescription());
        events.setEventsDate(eventsDto.getEventsDate());
        events.setEventImage(eventsDto.getEventImage());
        eventsRepository.save(events);
        return eventsDto;
    }

    @Override
    public String deleteEvents(int eventsId) {
        Events events = eventsRepository.findById(eventsId).get();
        eventsRepository.delete(events);
        return "Events Deleted";
    }

    @Override
    public EventsDto getEventsById(int eventsId) {
        Events events = this.eventsRepository.findById(eventsId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid events Id:" + eventsId));
        EventsDto eventsDto = new EventsDto();
        eventsDto.setEventsTitle(events.getEventsTitle());
        eventsDto.setEventsDescription(events.getEventsDescription());
        eventsDto.setEventsDate(events.getEventsDate());
        eventsDto.setEventImage(events.getEventImage());
        return eventsDto;
    }
}
