package com.example.cdrapplication.Models;

public class Call {
    private String callOriginNum;
    private String callDialedNum;
    private String IMSI;
    private String IMEI;
    private String callStartDateTime;
    private String callEndDateTime;
    private String inboundOutbound;
    private double callNetworkVolume;
    private double cellLacId;
    private double cellSiteId;
    private double Latitude;
    private double Longitude;
    private String callType;
    private String Location;

    public Call() {
    }

    public Call(String callOriginNum, String callDialedNum,
                String IMSI, String IMEI, String callStartDateTime,
                String callEndDateTime, String inboundOutbound, double callNetworkVolume,
                double cellLacId, double cellSiteId, double latitude, double longitude,
                String callType, String location) {
        this.callOriginNum = callOriginNum;
        this.callDialedNum = callDialedNum;
        this.IMSI = IMSI;
        this.IMEI = IMEI;
        this.callStartDateTime = callStartDateTime;
        this.callEndDateTime = callEndDateTime;
        this.inboundOutbound = inboundOutbound;
        this.callNetworkVolume = callNetworkVolume;
        this.cellLacId = cellLacId;
        this.cellSiteId = cellSiteId;
        Latitude = latitude;
        Longitude = longitude;
        this.callType = callType;
        Location = location;
    }

    public String getCallOriginNum() {
        return callOriginNum;
    }

    public void setCallOriginNum(String callOriginNum) {
        this.callOriginNum = callOriginNum;
    }

    public String getCallDialedNum() {
        return callDialedNum;
    }

    public void setCallDialedNum(String callDialedNum) {
        this.callDialedNum = callDialedNum;
    }

    public String getIMSI() {
        return IMSI;
    }

    public void setIMSI(String IMSI) {
        this.IMSI = IMSI;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getCallStartDateTime() {
        return callStartDateTime;
    }

    public void setCallStartDateTime(String callStartDateTime) {
        this.callStartDateTime = callStartDateTime;
    }

    public String getCallEndDateTime() {
        return callEndDateTime;
    }

    public void setCallEndDateTime(String callEndDateTime) {
        this.callEndDateTime = callEndDateTime;
    }

    public String getInboundOutbound() {
        return inboundOutbound;
    }

    public void setInboundOutbound(String inboundOutbound) {
        this.inboundOutbound = inboundOutbound;
    }

    public double getCallNetworkVolume() {
        return callNetworkVolume;
    }

    public void setCallNetworkVolume(double callNetworkVolume) {
        this.callNetworkVolume = callNetworkVolume;
    }

    public double getCellLacId() {
        return cellLacId;
    }

    public void setCellLacId(double cellLacId) {
        this.cellLacId = cellLacId;
    }

    public double getCellSiteId() {
        return cellSiteId;
    }

    public void setCellSiteId(double cellSiteId) {
        this.cellSiteId = cellSiteId;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
