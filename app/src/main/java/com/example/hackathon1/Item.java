package com.example.hackathon1;

public class Item {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTenderNum() {
        return tenderNum;
    }

    public void setTenderNum(long tenderNum) {
        this.tenderNum = tenderNum;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getTenderFormat() {
        return tenderFormat;
    }

    public void setTenderFormat(String tenderFormat) {
        this.tenderFormat = tenderFormat;
    }

    public int getTenderSumm() {
        return tenderSumm;
    }

    public void setTenderSumm(int tenderSumm) {
        this.tenderSumm = tenderSumm;
    }

    public int getSrok() {
        return srok;
    }

    public void setSrok(int srok) {
        this.srok = srok;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationPhone() {
        return organizationPhone;
    }

    public void setOrganizationPhone(String organizationPhone) {
        this.organizationPhone = organizationPhone;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public String getDateTimeStart() {
        return dateTimeStart;
    }

    public void setDateTimeStart(String dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    public String getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(String dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public String getLetterFile() {
        return letterFile;
    }

    public void setLetterFile(String letterFile) {
        this.letterFile = letterFile;
    }

    public String getLetterName() {
        return letterName;
    }

    public void setLetterName(String letterName) {
        this.letterName = letterName;
    }

    public String getLotsInfo() {
        return lotsInfo;
    }

    public void setLotsInfo(String lotsInfo) {
        this.lotsInfo = lotsInfo;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public Object getCompany_info() {
        return company_info;
    }

    public void setCompany_info(Object company_info) {
        this.company_info = company_info;
    }

    public Item(int id, long tenderNum, String tenderName, String tenderFormat, int tenderSumm, int srok, String organizationName, String organizationPhone, String organizationAddress, String dateTimeStart, String dateTimeEnd, String letterFile, String letterName, String lotsInfo, String moreInfo, int likes, int dislikes, Object company_info) {
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
    public Item() {

    }
}
