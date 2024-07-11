package com.example.genshinstart_backend.controller.student;

import com.github.pagehelper.PageInfo;
import com.example.genshinstart_backend.base.BaseApiController;
import com.example.genshinstart_backend.base.RestResponse;
import com.example.genshinstart_backend.domain.ExamPaperQuestionCustomerAnswer;
import com.example.genshinstart_backend.domain.Subject;
import com.example.genshinstart_backend.domain.TextContent;
import com.example.genshinstart_backend.domain.question.QuestionObject;
import com.example.genshinstart_backend.service.ExamPaperQuestionCustomerAnswerService;
import com.example.genshinstart_backend.service.QuestionService;
import com.example.genshinstart_backend.service.SubjectService;
import com.example.genshinstart_backend.service.TextContentService;
import com.example.genshinstart_backend.utility.DateTimeUtil;
import com.example.genshinstart_backend.utility.HtmlUtil;
import com.example.genshinstart_backend.utility.JsonUtil;
import com.example.genshinstart_backend.utility.PageInfoHelper;
import com.example.genshinstart_backend.viewmodel.admin.question.QuestionEditRequestVM;
import com.example.genshinstart_backend.viewmodel.student.exam.ExamPaperSubmitItemVM;
import com.example.genshinstart_backend.viewmodel.student.question.answer.QuestionAnswerVM;
import com.example.genshinstart_backend.viewmodel.student.question.answer.QuestionPageStudentRequestVM;
import com.example.genshinstart_backend.viewmodel.student.question.answer.QuestionPageStudentResponseVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("StudentQuestionAnswerController")
@RequestMapping(value = "/api/student/question/answer")
public class QuestionAnswerController extends BaseApiController {

    private final ExamPaperQuestionCustomerAnswerService examPaperQuestionCustomerAnswerService;
    private final QuestionService questionService;
    private final TextContentService textContentService;
    private final SubjectService subjectService;

    @Autowired
    public QuestionAnswerController(ExamPaperQuestionCustomerAnswerService examPaperQuestionCustomerAnswerService, QuestionService questionService, TextContentService textContentService, SubjectService subjectService) {
        this.examPaperQuestionCustomerAnswerService = examPaperQuestionCustomerAnswerService;
        this.questionService = questionService;
        this.textContentService = textContentService;
        this.subjectService = subjectService;
    }

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public RestResponse<PageInfo<QuestionPageStudentResponseVM>> pageList(@RequestBody QuestionPageStudentRequestVM model) {
        model.setCreateUser(getCurrentUser().getId());
        PageInfo<ExamPaperQuestionCustomerAnswer> pageInfo = examPaperQuestionCustomerAnswerService.studentPage(model);
        PageInfo<QuestionPageStudentResponseVM> page = PageInfoHelper.copyMap(pageInfo, q -> {
            Subject subject = subjectService.selectById(q.getSubjectId());
            QuestionPageStudentResponseVM vm = modelMapper.map(q, QuestionPageStudentResponseVM.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(q.getCreateTime()));
            TextContent textContent = textContentService.selectById(q.getQuestionTextContentId());
            QuestionObject questionObject = JsonUtil.toJsonObject(textContent.getContent(), QuestionObject.class);
            String clearHtml = HtmlUtil.clear(questionObject.getTitleContent());
            vm.setShortTitle(clearHtml);
            vm.setSubjectName(subject.getName());
            return vm;
        });
        return RestResponse.ok(page);
    }


    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
    public RestResponse<QuestionAnswerVM> select(@PathVariable Integer id) {
        QuestionAnswerVM vm = new QuestionAnswerVM();
        ExamPaperQuestionCustomerAnswer examPaperQuestionCustomerAnswer = examPaperQuestionCustomerAnswerService.selectById(id);
        ExamPaperSubmitItemVM questionAnswerVM = examPaperQuestionCustomerAnswerService.examPaperQuestionCustomerAnswerToVM(examPaperQuestionCustomerAnswer);
        QuestionEditRequestVM questionVM = questionService.getQuestionEditRequestVM(examPaperQuestionCustomerAnswer.getQuestionId());
        vm.setQuestionVM(questionVM);
        vm.setQuestionAnswerVM(questionAnswerVM);
        return RestResponse.ok(vm);
    }

}
