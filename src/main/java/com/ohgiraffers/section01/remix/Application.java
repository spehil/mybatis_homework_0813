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
            System.out.println("========== 메뉴 관리 ==========");
            System.out.println("1. 메뉴 전체 조회");
//            System.out.println("2. 메뉴 코드로 메뉴 조회");
            System.out.println("2. 신규 메뉴 추가");
            System.out.println("3. 메뉴 수정");
            System.out.println("4. 메뉴 삭제");


            int no = sc.nextInt();

            switch(no) {
                case 1 : exhibitionController.selectAllExhibition(); break;
           //     case 2 : exhibitionController.selectMenuByCode(inputExhibitionCode()); break;
                case 2 : exhibitionController.registExhibition(inputExhibition()); break;
                case 3 : exhibitionController.modifyExhibition(inputModifyExhibition()); break;
                case 4 : exhibitionController.deleteExhibition(inputExhibitionCode()); break;
//                default :
//                    System.out.println("잘못 된 메뉴를 선택하셨습니다.");
            }
        }while(true);
    }



    private static Map<String, String> inputExhibition() {

        Scanner sc = new Scanner(System.in);
        System.out.print("전시회 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("전시회 시작일을 입력하세요(예: 2023-08-05) : ");
        String startDay = sc.nextLine();
        System.out.print("전시회 종료일을 입력하세요(예: 2023-08-05) : ");
        String endDay = sc.nextLine();
        System.out.print("전시회 티켓가격을 입력하세요 : ");
        String price = sc.nextLine();
        System.out.print("지역 코드를 입력하세요 : ");
        String regionCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("startDay", startDay);
        parameter.put("endDay", endDay);
        parameter.put("price", price);
        parameter.put("regionCode", regionCode);

        return parameter;
    }
    private static Map<String, String> inputModifyExhibition() {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 전시회 코드를 입력하세요 : ");
        String code = sc.nextLine();
        System.out.print("수정할 전시회 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("수정할 전시회 티켓 가격을 입력하세요 : ");
        String price = sc.nextLine();
        System.out.print("수정할 지역 코드를 입력하세요 : ");
        String regionCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("regionCode", regionCode);

        return parameter;
    }

    private static  Map<String, String> inputExhibitionCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("전시회 코드를 입력하세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }



}
