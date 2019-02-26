package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.VO.GroupEvaluationVO;
import cn.cumtmaker.maker.model.GroupEvaluation;
import cn.cumtmaker.maker.service.GroupEvaluationService;
import cn.cumtmaker.maker.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping(value="api/evaluate",produces = {APPLICATION_JSON_UTF8_VALUE})
@RestController
@Api(value="api/evaluate",tags="EvaluationApi",description="Evaluate接口")
public class GroupEvaluationController {
    @Autowired
    GroupEvaluationService groupEvaluationService;
    @Autowired
    UserService userService;

    @ApiOperation("新增商品评分")
    @PostMapping
    public ResponseEntity addEvaluation(HttpServletRequest request, Integer storeId, Integer groupId, Float valueDisabled) {
        Integer userId = userService.getUserByRequest(request).getUserId();
        return ResponseEntity.ok(groupEvaluationService.addEvaluation(new GroupEvaluation(
                userId, storeId, groupId, valueDisabled
        )));
    }

    @ApiOperation("删除商品评分")
    @DeleteMapping
    public ResponseEntity deleteEvaluation(HttpServletRequest request, Integer storeId, Integer groupId, Float valueDisabled) {
        Integer userId = userService.getUserByRequest(request).getUserId();
        return ResponseEntity.ok(groupEvaluationService.deleteEvaluation(new GroupEvaluation(
                userId, storeId, groupId, valueDisabled
        )));
    }

    @ApiOperation("获得所有商品评分")
    @GetMapping
    public List<GroupEvaluationVO> getEvaluations(HttpServletRequest request) {
        Integer userId = userService.getUserByRequest(request).getUserId();
        return groupEvaluationService.getEvaluationsOfUser(userId);
    }
}
