package com.example.genshinstart_backend.repository;

import com.example.genshinstart_backend.domain.ExamPaperAnswer;
import com.example.genshinstart_backend.domain.other.KeyValue;
import com.example.genshinstart_backend.viewmodel.student.exampaper.ExamPaperAnswerPageVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ExamPaperAnswerMapper extends BaseMapper<ExamPaperAnswer> {

    List<ExamPaperAnswer> studentPage(ExamPaperAnswerPageVM requestVM);

    Integer selectAllCount();

    List<KeyValue> selectCountByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    ExamPaperAnswer getByPidUid(@Param("pid") Integer paperId, @Param("uid") Integer uid);

    List<ExamPaperAnswer> adminPage(com.example.genshinstart_backend.viewmodel.admin.paper.ExamPaperAnswerPageRequestVM requestVM);
}
