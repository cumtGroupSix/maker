package cn.cumtmaker.maker.service;

import java.util.List;

public interface ProductGroupService {
    Integer addProduct(Integer storeId, List<Integer> products);
}
