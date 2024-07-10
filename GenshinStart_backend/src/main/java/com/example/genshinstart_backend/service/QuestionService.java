package com.example.genshinstart_backend.service;

import com.github.pagehelper.PageInfo;
import com.example.genshinstart_backend.domain.Question;
import com.example.genshinstart_backend.viewmodel.admin.question.QuestionEditRequestVM;
import com.example.genshinstart_backend.viewmodel.admin.question.QuestionPageRequestVM;

import java.util.List;

public interface QuestionService extends BaseService<Question> {

    PageInfo<Question> page(QuestionPageRequestVM requestVM);

    Question insertFullQuestion(QuestionEditRequestVM model, Integer userId);

    Question updateFullQuestion(QuestionEditRequestVM model);

    QuestionEditRequestVM getQuestionEditRequestVM(Integer questionId);

    QuestionEditRequestVM getQuestionEditRequestVM(Question question);

    Integer selectAllCount();

    List<Integer> selectMothCount();
}
