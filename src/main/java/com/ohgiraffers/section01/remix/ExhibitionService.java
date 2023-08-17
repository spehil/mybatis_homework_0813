package com.ohgiraffers.section01.remix;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.section01.remix.Template.getSqlSession;

public class ExhibitionService {

    private ExhibitionMapper exhibitionMapper;
    public  List<ExhibitionDTO> selectAllExhibition() {

            SqlSession sqlSession = getSqlSession();

            exhibitionMapper = sqlSession.getMapper(ExhibitionMapper.class);
            List<ExhibitionDTO> exhibitionList = exhibitionMapper.selectAllExhibition();

            sqlSession.close();

            return exhibitionList;
        }


    public boolean registExhibition(ExhibitionDTO exhibition) {


        SqlSession sqlSession = getSqlSession();
        exhibitionMapper = sqlSession.getMapper(ExhibitionMapper.class);

        int result = exhibitionMapper.insertExhibition(exhibition);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;

    }

    public boolean modifyExhibition(ExhibitionDTO exhibition) {
        SqlSession sqlSession = getSqlSession();
        exhibitionMapper = sqlSession.getMapper(ExhibitionMapper.class);

        int result = exhibitionMapper.updateExhibition(exhibition);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean deletexhibition(int code) {
        SqlSession sqlSession = getSqlSession();
        exhibitionMapper = sqlSession.getMapper(ExhibitionMapper.class);

        int result = exhibitionMapper.deleteExhibition(code);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;

    }

    public List<ExhibitionDTO> selectExhibitionByPrice(int price) {


        SqlSession sqlSession = getSqlSession(); //mapper타입이 들어가있음.
        exhibitionMapper = sqlSession.getMapper(ExhibitionMapper.class);


        /*기본 자료형으로 조건문의 값을 비교하기 어려우므로 hashmap을 이용해서 파라미터를 전달한다. */
        /*(또는 DTO를 이용해서 전달한다.)*/
        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);


        List<ExhibitionDTO> exhibitionList = exhibitionMapper.selectMenuByPrice(map);

        if (exhibitionList != null && exhibitionList.size() > 0) {

            exhibitionList.forEach(System.out::println);

        } else {

            System.out.println("검색결과가 존재하지 않습니다. ");

        }


        sqlSession.close();

        return exhibitionList;


    }

}

