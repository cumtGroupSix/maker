package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    Product selectByProductId(Integer productId);
}