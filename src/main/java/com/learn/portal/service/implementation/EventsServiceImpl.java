package com.learn.portal.service.implementation;

import com.learn.portal.dto.EventsDto;
import com.learn.portal.entites.Events;
import com.learn.portal.repository.EventsRepository;
import com.learn.portal.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsServiceImpl implements EventsService {
    @Autowired
    private EventsRepository eventsRepository;


    @Override
    public EventsDto createEvents(EventsDto eventsDto) {
        Events events = new Events();
        events.setEventsTitle(eventsDto.getEventsTitle());
        events.setEventsDescription(eventsDto.getEventsDescription());
        events.setEventsDate(eventsDto.getEventsDate());
        events.setEventsPhoto(eventsDto.getEventsPhoto());
        eventsRepository.save(events);
        return eventsDto;

    }

    @Override
    public EventsDto getEvents() {
        Events events = eventsRepository.findAll().get(0);
        EventsDto eventsDto = new EventsDto();
        eventsDto.setEventsTitle(events.getEventsTitle());
        eventsDto.setEventsDescription(events.getEventsDescription());
        eventsDto.setEventsDate(events.getEventsDate());
        eventsDto.setEventsPhoto(events.getEventsPhoto());
        return eventsDto;
    }

    @Override
    public EventsDto updateEvents(int eventsId, EventsDto eventsDto) {
        Events events = eventsRepository.findById(eventsId).get();
        events.setEventsTitle(eventsDto.getEventsTitle());
        events.setEventsDescription(eventsDto.getEventsDescription());
        events.setEventsDate(eventsDto.getEventsDate());
        events.setEventsPhoto(eventsDto.getEventsPhoto());
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
        eventsDto.setEventsPhoto(events.getEventsPhoto());
        return eventsDto;
    }
}
