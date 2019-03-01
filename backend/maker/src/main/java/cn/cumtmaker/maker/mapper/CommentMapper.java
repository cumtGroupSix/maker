package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    /**
     * 添加评论
     * @param comment
     * @return 0/1
     */
    int insertComment(Comment comment);

    /**
     * 根据用户ID、商品ID删除评论
     * @param userId
     * @param productId
     * @return 0/1
     */
    int deleteComment(@Param("userId") Integer userId, @Param("productId") Integer productId);

    /**
     * 通过productId获取评价列表
     */
    List<Comment> getProductComments(Integer productId);

    /**
     * 根据商品ID删除评论
     * @param productId
     * @return 0/1
     */
    Integer deleteByProductId(Integer productId);
}
