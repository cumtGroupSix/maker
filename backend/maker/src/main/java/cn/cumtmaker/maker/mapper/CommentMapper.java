package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    int insertComment(Comment comment);
    int deleteComment(@Param("userId") Integer userId, @Param("productId") Integer productId);
    List<Comment> getProductComments(Integer productId);
    Integer deleteByProductId(Integer productId);
}
