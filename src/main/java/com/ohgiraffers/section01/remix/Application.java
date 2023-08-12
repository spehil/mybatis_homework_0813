package com.ohgiraffers.section01.remix;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ExhibitionController exhibitionController = new ExhibitionController();

        do{

            System.out.println("1. 전시회 전체 조회");

            int no = sc.nextInt();

            switch(no) {
                case 1 : exhibitionController.selectAllExhibition(); break;
            //    case 2 : exhibitionController.selectMenuByCode(inputExhibitionCode()); break;
                case 2 : exhibitionController.registExhibition(inputExhibition()); break;
//                case 4 : exhibitionController.modifyMenu(inputModifyMenu()); break;
//                case 5 : exhibitionController.deleteMenu(inputMenuCode()); break;
//                default :
//                    System.out.println("잘못 된 메뉴를 선택하셨습니다.");
            }
        }while(true);
    }

    private static Map<String, String> inputExhibition() {

        Scanner sc = new Scanner(System.in);
        System.out.print("전시회 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("전시회 시작일을 입력하세요(예: 20230805) : ");
        String startDay = sc.nextLine();
        System.out.print("전시회 종료일을 입력하세요(예: 20230805) : ");
        String endDay = sc.nextLine();
        System.out.print("전시회 티켓가격을 입력하세요 : ");
        int price = sc.nextInt();
        System.out.print("지역 코드를 입력하세요 : ");
        int regionCode = sc.nextInt();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("startDay", startDay);
        parameter.put("endDay", endDay);
        parameter.put("price", String.valueOf(price));
        parameter.put("regionCode", String.valueOf(regionCode));

        return parameter;
    }


}
