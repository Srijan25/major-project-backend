package com.learn.portal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.portal.entites.Announcement;
import com.learn.portal.service.AnnouncementService;

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
