package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.mapper.CommentMapper;
import cn.cumtmaker.maker.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    /**
     * 添加评论
     * @param comment
     * @return 0/1
     */
    public int insertComment (Comment comment) {
        return commentMapper.insertComment(comment);
    }

    /**
     * 根据用户ID、商品ID删除评论
     * @param userId
     * @param productId
     * @return 0/1
     */
    public int deleteComment(Integer userId,Integer productId){
        return commentMapper.deleteComment(userId,productId);
    }

    /**
     * 通过productId获取评价
     */
    public List<Comment> getProductComments(Integer productId) {
        return commentMapper.getProductComments(productId);
    }

    public Comment getComments (int productId) {
        return commentMapper.getComments(productId);
    }
}
