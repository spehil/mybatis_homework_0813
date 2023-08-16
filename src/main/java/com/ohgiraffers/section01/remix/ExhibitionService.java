package com.ohgiraffers.section01.remix;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

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
}

