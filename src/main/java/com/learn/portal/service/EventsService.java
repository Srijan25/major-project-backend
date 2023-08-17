package com.learn.portal.service;

import com.learn.portal.dto.EventsDto;

import java.util.List;

public interface EventsService {
    EventsDto createEvents(EventsDto eventsDto);

    List<EventsDto> getEvents();

    EventsDto updateEvents(int eventsId, EventsDto eventsDto);

    String deleteEvents(int eventsId);
    EventsDto getEventsById(int eventsId);

}
