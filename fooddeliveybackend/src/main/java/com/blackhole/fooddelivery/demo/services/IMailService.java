package com.blackhole.fooddelivery.demo.services;

import javax.mail.MessagingException;
import javax.naming.Context;

public interface IMailService {
    void sendEmail(String toa, String subjecta, String contencta);
    }
