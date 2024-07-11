package com.example.genshinstart_backend.controller.wx.student;

import com.github.pagehelper.PageInfo;
import com.example.genshinstart_backend.base.RestResponse;
import com.example.genshinstart_backend.controller.wx.BaseWXApiController;
import com.example.genshinstart_backend.domain.ExamPaper;
import com.example.genshinstart_backend.domain.Subject;
import com.example.genshinstart_backend.service.ExamPaperService;
import com.example.genshinstart_backend.service.SubjectService;
import com.example.genshinstart_backend.utility.DateTimeUtil;
import com.example.genshinstart_backend.utility.PageInfoHelper;
import com.example.genshinstart_backend.viewmodel.admin.exam.ExamPaperEditRequestVM;
import com.example.genshinstart_backend.viewmodel.student.exam.ExamPaperPageResponseVM;
import com.example.genshinstart_backend.viewmodel.student.exam.ExamPaperPageVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller("WXStudentExamController")
@RequestMapping(value = "/api/wx/student/exampaper")
@ResponseBody
public class ExamPaperController extends BaseWXApiController {

    private final ExamPaperService examPaperService;
    private final SubjectService subjectService;

    @Autowired
    public ExamPaperController(ExamPaperService examPaperService, SubjectService subjectService) {
        this.examPaperService = examPaperService;
        this.subjectService = subjectService;
    }


    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
    public RestResponse<ExamPaperEditRequestVM> select(@PathVariable Integer id) {
        ExamPaperEditRequestVM vm = examPaperService.examPaperToVM(id);
        return RestResponse.ok(vm);
    }


    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    public RestResponse<PageInfo<ExamPaperPageResponseVM>> pageList(@Valid ExamPaperPageVM model) {
        model.setLevelId(getCurrentUser().getUserLevel());
        PageInfo<ExamPaper> pageInfo = examPaperService.studentPage(model);
        PageInfo<ExamPaperPageResponseVM> page = PageInfoHelper.copyMap(pageInfo, e -> {
            ExamPaperPageResponseVM vm = modelMapper.map(e, ExamPaperPageResponseVM.class);
            Subject subject = subjectService.selectById(vm.getSubjectId());
            vm.setSubjectName(subject.getName());
            vm.setCreateTime(DateTimeUtil.dateFormat(e.getCreateTime()));
            return vm;
        });
        return RestResponse.ok(page);
    }
}
