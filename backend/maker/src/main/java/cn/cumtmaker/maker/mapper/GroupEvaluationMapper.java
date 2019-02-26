package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.GroupEvaluation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GroupEvaluationMapper {
    List<GroupEvaluation> getEvaluationsOfUser(int userId);
    int addEvaluation(GroupEvaluation groupEvaluation);
    int deleteEvaluation(GroupEvaluation groupEvaluation);
}