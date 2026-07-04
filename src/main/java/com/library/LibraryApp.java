package com.library;

import com.library.config.HbmConfig;
import org.hibernate.SessionFactory;

public class LibraryApp {
    public static void main(String[] args) {
        System.out.println("Library Management System");
        SessionFactory sessionFactory = HbmConfig.getSessionFactory();
        System.out.println("Session Factory created successfully");
        HbmConfig.closeSessionFactory();
    }
}
