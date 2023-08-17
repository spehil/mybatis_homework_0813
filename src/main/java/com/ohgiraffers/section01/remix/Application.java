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
            System.out.println("2. 검색어로 전시회 조회");
            System.out.println("2. 신규 메뉴 추가");
            System.out.println("3. 메뉴 수정");
            System.out.println("4. 메뉴 삭제");


            int no = sc.nextInt();

            switch(no) {
                case 1 : exhibitionController.selectAllExhibition(); break;
                case 2 : inputExhibitionSearch(); break;
                case 3 : exhibitionController.registExhibition(inputExhibition()); break;
                case 4 : exhibitionController.modifyExhibition(inputModifyExhibition()); break;
                case 5 : exhibitionController.deleteExhibition(inputExhibitionCode()); break;
               default :
                   System.out.println("잘못 된 메뉴를 선택하셨습니다.");
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


    private static void inputExhibitionSearch() {

        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("=====검색어에 맞는 전시회 조회 =======");
            System.out.println("1. if로 조회하기");
            System.out.println("2. choose(when,otherwise)조회하기");
            System.out.println("3. foreach 조회하기");
            System.out.println("4. trim(where,set) 조회하기");
            System.out.println("9. 종료하기");
            System.out.println("메뉴를 선택하세요 :");
            int no = sc.nextInt();

            switch (no) {

                case 1:
                    ifSubMenu();
                    break;
//                case 2:
//                    chooseSubMenu();
//                    break;
//                case 3:
//                    foreachSubMENU();
//                    break;
//                case 4:
//                    trimSubMenu();
//                    break;
//                case 9:
//                    System.out.println("프로그램을 종료합니다");return;
            }
        } while (true);
    }

    private static void ifSubMenu() {
          Scanner sc = new Scanner(System.in);
          ExhibitionController exhibitionController = new ExhibitionController();

        do {

            System.out.println("======= if서브 메뉴 ==========");
            System.out.println("1. 원하는 금액대에 적합한 전시회 보여주기");
            System.out.println("2. 전시회 이름 혹은 지역명으로 검색하여 전시회 보여주기 ");
            System.out.println("9. 이전 메뉴로");
            System.out.println("메뉴 번호를 입력하세요");
            int no = sc.nextInt();

            switch (no) {

                case 1:
                    exhibitionController.selectExhibitionByPrice(inputPrice());
                    break;
//                case 2:
//                    menuService.searchMenu(inputSearchCriteria());
//                    break;
//
//                case 9:
//                    return;

            }

        } while (true);
    }

    private static Map<String, String> inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색하실 가격의 최대 금액을 입력해주세요 :");
        String price = sc.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("price", price);

        return parameter;
    }


}







