package com.learn.portal.controllers;

import com.learn.portal.dto.EventsDto;
import com.learn.portal.service.EventsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @GetMapping("/events")
    public ResponseEntity<EventsDto> getEvents() {
        EventsDto eventsDto = this.eventsService.getEvents();
        return new ResponseEntity<>(eventsDto, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<EventsDto> createEvents(@Valid @RequestBody EventsDto eventsDto) {
        EventsDto createdEvents = this.eventsService.createEvents(eventsDto);
        return new ResponseEntity<>(createdEvents, HttpStatus.CREATED);
    }

    @PostMapping("/uploadpic/{eventsId}")
    public ResponseEntity<EventsDto> uploadPic(@PathVariable int eventsId, @Valid @RequestBody EventsDto eventsDto) {
        EventsDto createdEvents = this.eventsService.uploadPic(eventsId, eventsDto);
        return new ResponseEntity<>(createdEvents, HttpStatus.CREATED);
    }

    @PutMapping("/update/{eventsId}")
    public ResponseEntity<EventsDto> updateEvents(@PathVariable int eventsId, @RequestParam("image") MultipartFile image, @Valid @RequestBody EventsDto eventsDto) {
        EventsDto eventsDto =this.eventsService
    }



    @DeleteMapping("/delete/{eventsId}")
    public ResponseEntity<String> deleteEvents(@PathVariable int eventsId) {
        String message = this.eventsService.deleteEvents(eventsId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
