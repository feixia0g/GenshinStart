package com.example.genshinstart_backend.controller.admin;

import com.github.pagehelper.PageInfo;
import com.example.genshinstart_backend.base.BaseApiController;
import com.example.genshinstart_backend.base.RestResponse;
import com.example.genshinstart_backend.domain.ExamPaperAnswer;
import com.example.genshinstart_backend.domain.Subject;
import com.example.genshinstart_backend.domain.User;
import com.example.genshinstart_backend.service.*;
import com.example.genshinstart_backend.utility.DateTimeUtil;
import com.example.genshinstart_backend.utility.ExamUtil;
import com.example.genshinstart_backend.utility.PageInfoHelper;
import com.example.genshinstart_backend.viewmodel.admin.paper.ExamPaperAnswerPageRequestVM;
import com.example.genshinstart_backend.viewmodel.student.exampaper.ExamPaperAnswerPageResponseVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("AdminExamPaperAnswerController")
@RequestMapping(value = "/api/admin/examPaperAnswer")
public class ExamPaperAnswerController extends BaseApiController {

    private final ExamPaperAnswerService examPaperAnswerService;
    private final SubjectService subjectService;
    private final UserService userService;

    @Autowired
    public ExamPaperAnswerController(ExamPaperAnswerService examPaperAnswerService, SubjectService subjectService, UserService userService) {
        this.examPaperAnswerService = examPaperAnswerService;
        this.subjectService = subjectService;
        this.userService = userService;
    }


    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public RestResponse<PageInfo<ExamPaperAnswerPageResponseVM>> pageJudgeList(@RequestBody ExamPaperAnswerPageRequestVM model) {
        PageInfo<ExamPaperAnswer> pageInfo = examPaperAnswerService.adminPage(model);
        PageInfo<ExamPaperAnswerPageResponseVM> page = PageInfoHelper.copyMap(pageInfo, e -> {
            ExamPaperAnswerPageResponseVM vm = modelMapper.map(e, ExamPaperAnswerPageResponseVM.class);
            Subject subject = subjectService.selectById(vm.getSubjectId());
            vm.setDoTime(ExamUtil.secondToVM(e.getDoTime()));
            vm.setSystemScore(ExamUtil.scoreToVM(e.getSystemScore()));
            vm.setUserScore(ExamUtil.scoreToVM(e.getUserScore()));
            vm.setPaperScore(ExamUtil.scoreToVM(e.getPaperScore()));
            vm.setSubjectName(subject.getName());
            vm.setCreateTime(DateTimeUtil.dateFormat(e.getCreateTime()));
            User user = userService.selectById(e.getCreateUser());
            vm.setUserName(user.getUserName());
            return vm;
        });
        return RestResponse.ok(page);
    }


}
