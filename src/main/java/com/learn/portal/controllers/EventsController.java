package com.learn.portal.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.learn.portal.dto.EventsDto;
import com.learn.portal.service.EventsService;
import com.learn.portal.service.FileService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @Autowired
    private FileService fileService;

    @GetMapping("/events")
    public ResponseEntity<List<EventsDto>> getEvents() {
        List<EventsDto> eventsDtos = this.eventsService.getEvents();
        return new ResponseEntity<>(eventsDtos, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<EventsDto> createEvents(@Valid @RequestBody EventsDto eventsDto) {
        EventsDto createdEvents = this.eventsService.createEvents(eventsDto);
        return new ResponseEntity<>(createdEvents, HttpStatus.CREATED);
    }



    @PutMapping("/update/{eventsId}")
    public ResponseEntity<EventsDto> updateEvents(@PathVariable int eventsId, @Valid @RequestBody EventsDto eventsDto) {
        EventsDto updatedEvents = this.eventsService.updateEvents(eventsId, eventsDto);
        return new ResponseEntity<>(updatedEvents, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{eventsId}")
    public ResponseEntity<String> deleteEvents(@PathVariable int eventsId) {
        String message = this.eventsService.deleteEvents(eventsId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/event/img_upload/{eventId}")
    public ResponseEntity<EventsDto> uploadProductImage(@RequestParam("image") MultipartFile image,
                                                      @PathVariable Integer eventId) throws IOException {

        EventsDto eventsDto = this.eventsService.getEventsById(eventId);

        String fileName = this.fileService.uploadImage(image);

        eventsDto.setEventImage(fileName);
        EventsDto updatedEvent = this.eventsService.updateEvents(eventId, eventsDto);
        return new ResponseEntity<EventsDto>(updatedEvent, HttpStatus.OK);



    }

    @GetMapping(value = "/event/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void viewImage(@PathVariable String imageName, HttpServletResponse response) throws IOException {

        InputStream resource = this.fileService.getResource(imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource, response.getOutputStream());
    }


}
