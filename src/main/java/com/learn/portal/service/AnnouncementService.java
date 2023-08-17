package com.learn.portal.service;

import com.learn.portal.entites.Announcement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AnnouncementService {

    Announcement createAnnouncement(Announcement announcement);



   List<Announcement> getAllAnnouncements();



    Announcement updateAnnouncement(Announcement announcement);

    void deleteAnnouncement(Integer id);
}
