package com.example.genshinstart_backend.controller.student;

import com.github.pagehelper.PageInfo;
import com.example.genshinstart_backend.base.BaseApiController;
import com.example.genshinstart_backend.base.RestResponse;
import com.example.genshinstart_backend.domain.ExamPaper;
import com.example.genshinstart_backend.service.ExamPaperAnswerService;
import com.example.genshinstart_backend.service.ExamPaperService;
import com.example.genshinstart_backend.utility.DateTimeUtil;
import com.example.genshinstart_backend.utility.PageInfoHelper;
import com.example.genshinstart_backend.viewmodel.admin.exam.ExamPaperEditRequestVM;
import com.example.genshinstart_backend.viewmodel.student.exam.ExamPaperPageResponseVM;
import com.example.genshinstart_backend.viewmodel.student.exam.ExamPaperPageVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("StudentExamPaperController")
@RequestMapping(value = "/api/student/exam/paper")
public class ExamPaperController extends BaseApiController {

    private final ExamPaperService examPaperService;
    private final ExamPaperAnswerService examPaperAnswerService;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public ExamPaperController(ExamPaperService examPaperService, ExamPaperAnswerService examPaperAnswerService, ApplicationEventPublisher eventPublisher) {
        this.examPaperService = examPaperService;
        this.examPaperAnswerService = examPaperAnswerService;
        this.eventPublisher = eventPublisher;
    }


    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
    public RestResponse<ExamPaperEditRequestVM> select(@PathVariable Integer id) {
        ExamPaperEditRequestVM vm = examPaperService.examPaperToVM(id);
        return RestResponse.ok(vm);
    }


    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    public RestResponse<PageInfo<ExamPaperPageResponseVM>> pageList(@RequestBody @Valid ExamPaperPageVM model) {
        PageInfo<ExamPaper> pageInfo = examPaperService.studentPage(model);
        PageInfo<ExamPaperPageResponseVM> page = PageInfoHelper.copyMap(pageInfo, e -> {
            ExamPaperPageResponseVM vm = modelMapper.map(e, ExamPaperPageResponseVM.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(e.getCreateTime()));
            return vm;
        });
        return RestResponse.ok(page);
    }
}
