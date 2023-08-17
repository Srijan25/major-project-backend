package com.learn.portal.service;

import java.util.List;

import com.learn.portal.dto.EventsDto;

public interface EventsService {
    EventsDto createEvents(EventsDto eventsDto);

    List<EventsDto> getEvents();

    EventsDto updateEvents(int eventsId, EventsDto eventsDto);

    String deleteEvents(int eventsId);
    EventsDto getEventsById(int eventsId);

}
