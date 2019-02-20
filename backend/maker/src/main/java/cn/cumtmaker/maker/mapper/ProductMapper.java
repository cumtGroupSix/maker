package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.form.ProductFormObject;
import cn.cumtmaker.maker.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    Product selectByProductId(Integer productId);
<<<<<<< HEAD

    List<Integer> getValueIdsByProductId(Integer productId);

    Integer insert(ProductFormObject productFormObject);
=======
>>>>>>> d32cc79a215a021487d2338465b01f0131539145
}
