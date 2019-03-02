package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.mapper.CategoryMapper;
import cn.cumtmaker.maker.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryMapper categoryMapper;

    /**
     * 返回所有类目
     * @return
     */
    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryMapper.getAll();
    }


}
