package com.ohgiraffers.section01.remix;

import java.time.LocalDate;
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
    private LocalDate exhibitionStart;
    private LocalDate exhibitionEnd;

    private int price;

    private int regionCode;

    public ExhibitionDTO() {
    }

    public ExhibitionDTO(int code, String exhibitionName, LocalDate exhibitionStart, LocalDate exhibitionEnd, int price, int regionCode) {
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

    public LocalDate getExhibitionStart() {
        return exhibitionStart;
    }

    public void setExhibitionStart(LocalDate exhibitionStart) {
        this.exhibitionStart = exhibitionStart;
    }

    public LocalDate getExhibitionEnd() {
        return exhibitionEnd;
    }

    public void setExhibitionEnd(LocalDate exhibitionEnd) {
        this.exhibitionEnd = exhibitionEnd;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRegionCode() {
        return regionCode;
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
