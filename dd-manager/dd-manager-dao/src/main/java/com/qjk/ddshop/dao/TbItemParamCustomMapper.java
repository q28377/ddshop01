package com.qjk.ddshop.dao;

import com.qjk.ddshop.pojo.vo.TbItemParamCustom;

import java.util.List;
import java.util.Map;

public interface TbItemParamCustomMapper {
    int countItemParams();

    List<TbItemParamCustom> listItemParamsByPage(Map<String, Object> map);
}
