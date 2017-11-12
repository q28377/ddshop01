package com.qjk.ddshop.service;

import com.qjk.ddshop.common.dto.TreeNode;

import java.util.List;

public interface ItemCatService {
    public List<TreeNode> listItemCatsByPid(Long parentId);
}
