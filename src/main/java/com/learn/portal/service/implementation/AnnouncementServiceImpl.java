package com.learn.portal.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.portal.entites.Announcement;
@Service
public class AnnouncementServiceImpl implements com.learn.portal.service.AnnouncementService{

    @Autowired
    private com.learn.portal.repository.AccouncementRepository announcementRepository;

    @Autowired
    private org.modelmapper.ModelMapper modelMapper;
    @Override
    public Announcement createAnnouncement(Announcement announcement) {
        Announcement savedAnnouncement = this.announcementRepository.save(announcement);
        return savedAnnouncement;
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        List<Announcement> announcements = this.announcementRepository.findAll();
        return announcements;
    }

    @Override
    public Announcement updateAnnouncement(Announcement announcement) {
        Announcement savedAnnouncement = this.announcementRepository.save(announcement);
        return savedAnnouncement;

    }

    @Override
    public void deleteAnnouncement(Integer id) {
        Announcement announcement = this.announcementRepository.findById(id).orElseThrow();
        this.announcementRepository.delete(announcement);

    }


}
