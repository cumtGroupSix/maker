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

    public int insertComment (Comment comment) {
        return commentMapper.insertComment(comment);
    }


    public int deleteComment(Integer userId,Integer productId){
        return commentMapper.deleteComment(userId,productId);
    }

    public List<Comment> getProductComments(Integer productId) {
        return commentMapper.getProductComments(productId);
    }
}
