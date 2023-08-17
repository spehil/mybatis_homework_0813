package com.ohgiraffers.section01.remix;

import java.util.List;
import java.util.Map;

public interface ExhibitionMapper {
    List<ExhibitionDTO> selectAllExhibition();


    int insertExhibition(ExhibitionDTO exhibition);

    int updateExhibition(ExhibitionDTO exhibition);

    int deleteExhibition(int code);

    List<ExhibitionDTO> selectSearchExhibition();

    List<ExhibitionDTO> selectMenuByPrice(Map<String, Integer> map);
}
