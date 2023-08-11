package com.learn.portal.service;

import com.learn.portal.dto.EventsDto;

public interface EventsService {
    EventsDto createEvents(EventsDto eventsDto);

    EventsDto getEvents();

    EventsDto updateEvents(int eventsId, EventsDto eventsDto);

    String deleteEvents(int eventsId);
}
