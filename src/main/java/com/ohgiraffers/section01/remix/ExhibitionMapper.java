package com.ohgiraffers.section01.remix;

import java.util.List;

public interface ExhibitionMapper {
    List<ExhibitionDTO> selectAllExhibition();


    int insertExhibition(ExhibitionDTO exhibition);

    int updateExhibition(ExhibitionDTO exhibition);

    int deleteExhibition(int code);
}
