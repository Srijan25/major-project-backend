package com.learn.portal.service;

import java.util.List;

import com.learn.portal.entites.Announcement;

public interface AnnouncementService {

    Announcement createAnnouncement(Announcement announcement);



   List<Announcement> getAllAnnouncements();



    Announcement updateAnnouncement(Announcement announcement);

    void deleteAnnouncement(Integer id);
}
