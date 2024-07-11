package com.example.genshinstart_backend.service;

import com.github.pagehelper.PageInfo;
import com.example.genshinstart_backend.domain.ExamPaper;
import com.example.genshinstart_backend.domain.User;
import com.example.genshinstart_backend.viewmodel.admin.exam.ExamPaperEditRequestVM;
import com.example.genshinstart_backend.viewmodel.admin.exam.ExamPaperPageRequestVM;
import com.example.genshinstart_backend.viewmodel.student.dashboard.PaperFilter;
import com.example.genshinstart_backend.viewmodel.student.dashboard.PaperInfo;
import com.example.genshinstart_backend.viewmodel.student.exam.ExamPaperPageVM;

import java.util.List;

public interface ExamPaperService extends BaseService<ExamPaper> {

    PageInfo<ExamPaper> page(ExamPaperPageRequestVM requestVM);

    PageInfo<ExamPaper> taskExamPage(ExamPaperPageRequestVM requestVM);

    PageInfo<ExamPaper> studentPage(ExamPaperPageVM requestVM);

    ExamPaper savePaperFromVM(ExamPaperEditRequestVM examPaperEditRequestVM, User user);

    ExamPaperEditRequestVM examPaperToVM(Integer id);

    List<PaperInfo> indexPaper(PaperFilter paperFilter);

    Integer selectAllCount();

    List<Integer> selectMothCount();
}
