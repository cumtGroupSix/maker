package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentMapper {
    int insertComment(Comment comment);
    int deleteComment(@Param("userId") Integer userId, @Param("productId") Integer productId);
}