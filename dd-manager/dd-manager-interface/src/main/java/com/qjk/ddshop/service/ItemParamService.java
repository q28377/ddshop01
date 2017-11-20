package com.qjk.ddshop.service;

import com.qjk.ddshop.common.dto.Page;
import com.qjk.ddshop.common.dto.Result;
import com.qjk.ddshop.pojo.po.TbItemParam;
import com.qjk.ddshop.pojo.vo.TbItemParamCustom;

public interface ItemParamService {
    /**
     * 对参数规格说明表进行分页操作
     * @param page
     * @return
     */
    Result<TbItemParamCustom> listItemParamsByPage(Page page);
    TbItemParam getItemParamByCid(Long cid);
}
