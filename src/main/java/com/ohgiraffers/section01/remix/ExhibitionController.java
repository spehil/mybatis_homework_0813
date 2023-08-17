package com.ohgiraffers.section01.remix;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

public class ExhibitionController {


      ExhibitionService exhibitionService = new ExhibitionService();
      PrintResult printResult = new PrintResult();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public void selectAllExhibition() {

        List<ExhibitionDTO> exhibitionList = exhibitionService.selectAllExhibition();

        if(exhibitionList != null) {
            printResult.printExhibitionList(exhibitionList);
        } else {
            printResult.printErrorMessage("selectList");
        }

    }

    public void registExhibition(Map<String, String> parameter) throws ParseException {


        String name = parameter.get("name");

        LocalDate startDay = null;
        LocalDate endDay = null;

        try {
            startDay = LocalDate.parse(parameter.get("startDay"), formatter);
            endDay = LocalDate.parse(parameter.get("endDay"), formatter);
        } catch (DateTimeParseException e) {
            // 날짜 형식이 맞지 않는 경우 처리
            e.printStackTrace();
        }


        int price = Integer.parseInt(parameter.get("price"));
        int regionCode = Integer.parseInt(parameter.get("regionCode"));


        ExhibitionDTO exhibition = new ExhibitionDTO();

        exhibition.setExhibitionName(name);
        exhibition.setExhibitionStart(startDay);
        exhibition.setExhibitionEnd(endDay);
        exhibition.setPrice(price);
        exhibition.setRegionCode(regionCode);


        if (exhibitionService.registExhibition(exhibition)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }


    }

    public void modifyExhibition(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int regionCode = Integer.parseInt(parameter.get("regionCode"));

        ExhibitionDTO exhibition = new ExhibitionDTO();
        exhibition.setCode(code);
        exhibition.setExhibitionName(name);
        exhibition.setPrice(price);
        exhibition.setRegionCode(regionCode);

        if(exhibitionService.modifyExhibition(exhibition)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteExhibition(Map<String, String> parameter) {


            int code = Integer.parseInt(parameter.get("code"));

            if(exhibitionService.deletexhibition(code)) {
                printResult.printSuccessMessage("delete");
            } else {
                printResult.printErrorMessage("delete");
            }

        }

    public void selectExhibitionByPrice(Map<String, String> parameter) {

        int price = Integer.parseInt(parameter.get("price"));

        List<ExhibitionDTO> exhibitionList = exhibitionService.selectExhibitionByPrice(price);

        if(exhibitionList != null) {
            printResult.printExhibitionList(exhibitionList);
        } else {
            printResult.printErrorMessage("selectList");
        }



    }
}
