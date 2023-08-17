package com.learn.portal.service.implementation;

import com.learn.portal.entites.Announcement;
import org.springframework.beans.factory.annotation.Autowired;

public class AnnouncementServiceImpl implements com.learn.portal.service.AnnouncementService{

    @Autowired
    private com.learn.portal.repository.AnnouncementRepository announcementRepository;

    @Autowired
    private org.modelmapper.ModelMapper modelMapper;
    @Override
    public Announcement createAnnouncement(Announcement announcement) {
        return null;
    }

    @Override
    public Announcement viewAnnouncement() {
        return null;
    }
}
