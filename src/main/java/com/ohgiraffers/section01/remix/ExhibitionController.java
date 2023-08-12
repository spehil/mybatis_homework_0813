package com.ohgiraffers.section01.remix;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExhibitionController {


      ExhibitionService exhibitionService = new ExhibitionService();
      PrintResult printResult = new PrintResult();

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일");


    public void selectAllExhibition() {

        List<ExhibitionDTO> exhibitionList = exhibitionService.selectAllExhibition();

        if(exhibitionList != null) {
            printResult.printExhibitionList(exhibitionList);
        } else {
            printResult.printErrorMessage("selectList");
        }

    }

    public void registExhibition(Map<String, String> parameter) throws ParseException {

     /*   Scanner sc = new Scanner(System.in);
        System.out.print("전시회 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("전시회 시작일을 입력하세요(예: 20230805) : ");
        String startDay = sc.nextLine();
        System.out.print("전시회 종료일을 입력하세요(예: 20230805) : ");
        String endDay = sc.nextLine();
        System.out.print("전시회 티켓가격을 입력하세요 : ");
        int price = sc.nextInt();
        System.out.print("지역 코드를 입력하세요 : ");
        int regionCode = sc.nextInt();*/

        String name = parameter.get("name");
        Date startDay;
        Date endDay;
        try {
            startDay = formatter.parse(parameter.get("startDay"));
            endDay = formatter.parse(parameter.get("endDay"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        int price = Integer.parseInt(parameter.get("price"));
        int regionCode = Integer.parseInt(parameter.get("regionCode"));


        ExhibitionDTO exhibition = new ExhibitionDTO();

        exhibition.setExhibitionName(name);
        exhibition.setExhibitionStart(startDay);
        exhibition.setExhibitionEnd(endDay);
        exhibition.getPrice(price);
        exhibition.getRegionCode(regionCode);


        if (exhibitionService.registExhibition(exhibition)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }


    }
}
