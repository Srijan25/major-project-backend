package com.learn.portal.service;

import com.learn.portal.entites.Announcement;
import org.springframework.beans.factory.annotation.Autowired;

public interface AnnouncementService {

    Announcement createAnnouncement(Announcement announcement);



    Announcement viewAnnouncement();
}
