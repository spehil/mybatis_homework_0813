package com.ohgiraffers.section01.remix;

import java.util.Date;

public class ExhibitionDTO {

   /* EXHIBITION_CODE NUMBER  NOT NULL
             ,  EXHIBITION_NAME VARCHAR(50) NOT NULL
                      ,  EXHIBITION_START DATE NOT NULL
             ,  EXHIBITION_END DATE NOT NULL
              , EXHIBITION_PRICE NUMBER NOT NULL
                      , REGION_CODE  NUMBER CONSTRAINT FK_REGION_CODE  REFERENCES REGION(REGION_CODE)*/

    private int code;
    private  String exhibitionName;
    private Date exhibitionStart;
    private Date exhibitionEnd;

    private int price;

    private int regionCode;

    public ExhibitionDTO() {
    }

    public ExhibitionDTO(int code, String exhibitionName, Date exhibitionStart, Date exhibitionEnd, int price, int regionCode) {
        this.code = code;
        this.exhibitionName = exhibitionName;
        this.exhibitionStart = exhibitionStart;
        this.exhibitionEnd = exhibitionEnd;
        this.price = price;
        this.regionCode = regionCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getExhibitionName() {
        return exhibitionName;
    }

    public void setExhibitionName(String exhibitionName) {
        this.exhibitionName = exhibitionName;
    }

    public Date getExhibitionStart() {
        return exhibitionStart;
    }

    public void setExhibitionStart(Date exhibitionStart) {
        this.exhibitionStart = exhibitionStart;
    }

    public Date getExhibitionEnd() {
        return exhibitionEnd;
    }

    public void setExhibitionEnd(Date exhibitionEnd) {
        this.exhibitionEnd = exhibitionEnd;
    }

    public int getPrice(int price) {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRegionCode(int regionCode) {
        return this.regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.regionCode = regionCode;
    }

    @Override
    public String toString() {
        return "ExhibitionDTO{" +
                "code=" + code +
                ", exhibitionName='" + exhibitionName + '\'' +
                ", exhibitionStart=" + exhibitionStart +
                ", exhibitionEnd=" + exhibitionEnd +
                ", price=" + price +
                ", regionCode=" + regionCode +
                '}';
    }
}
