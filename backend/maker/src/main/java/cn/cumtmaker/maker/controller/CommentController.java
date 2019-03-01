package cn.cumtmaker.maker.controller;


import cn.cumtmaker.maker.model.Comment;
import cn.cumtmaker.maker.service.impl.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


@RequestMapping(value = "api/comment", produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
@Api(value = "api/comment", tags = "commentApi", description = "评论接口")
public class CommentController {
   @Autowired
   CommentService commentService;

    /**
     * 添加评论信息
     * @param comment
     * @return 0/1
     */
   @ResponseBody
    @PostMapping(value = "/insertComment",consumes="application/json")
    @ApiOperation(value = "添加评论信息", response = Comment.class, responseContainer = "list")
    public ResponseEntity insertComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.insertComment(comment));
    }

    /**
     *删除评论
     * @param userId
     * @param productId
     * @return 0/1
     */
    @ResponseBody
    @DeleteMapping("/deleteComment")
    @ApiOperation(value = "删除评论")
    public ResponseEntity deleteComment(Integer userId, Integer productId){
        return  ResponseEntity.ok(commentService.deleteComment(userId,productId));
    }
}
