package com.example.hackathon1;

public class TenderModel {
    public TenderModel(int id, long tenderNum, String tenderName, String tenderFormat, int tenderSumm, int srok, String organizationName, String organizationPhone, String organizationAddress, String dateTimeStart, String dateTimeEnd, String letterFile, String letterName, String lotsInfo, String moreInfo, int likes, int dislikes, Object company_info) {
        this.id = id;
        this.tenderNum = tenderNum;
        this.tenderName = tenderName;
        this.tenderFormat = tenderFormat;
        this.tenderSumm = tenderSumm;
        this.srok = srok;
        this.organizationName = organizationName;
        this.organizationPhone = organizationPhone;
        this.organizationAddress = organizationAddress;
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
        this.letterFile = letterFile;
        this.letterName = letterName;
        this.lotsInfo = lotsInfo;
        this.moreInfo = moreInfo;
        this.likes = likes;
        this.dislikes = dislikes;
        this.company_info = company_info;
    }


    private int id;
    private long tenderNum;
    private String tenderName;
    private String tenderFormat;
    private int tenderSumm;
    private int srok;
    private String organizationName;
    private String organizationPhone;
    private String organizationAddress;
    private String dateTimeStart;
    private String dateTimeEnd;
    private String letterFile;
    private String letterName;
    private String lotsInfo;
    private String moreInfo;
    private int likes;
    private int dislikes;
    private Object company_info;

    // Геттеры и сеттеры для полей, конструктор и другие методы по необходимости
}

