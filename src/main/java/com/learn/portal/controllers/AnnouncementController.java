package com.learn.portal.controllers;

import com.learn.portal.entites.Announcement;
import com.learn.portal.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ann")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    @PostMapping("/create")
    public Announcement createAnnouncement(@RequestBody Announcement announcement){
        return this.announcementService.createAnnouncement(announcement);
    }
    @GetMapping("/view")
    public List<Announcement> viewAnnouncement(){
        return this.announcementService.getAllAnnouncements();
    }
}
