package cn.cumtmaker.maker.service;

import cn.cumtmaker.maker.VO.GroupEvaluationVO;
import cn.cumtmaker.maker.model.GroupEvaluation;

import java.util.List;

public interface GroupEvaluationService {
    List<GroupEvaluationVO> getEvaluationsOfUser(int userId);
    int addEvaluation(GroupEvaluation groupEvaluation);
    int deleteEvaluation(GroupEvaluation groupEvaluation);
}
