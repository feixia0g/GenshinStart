package com.example.genshinstart_backend.service;

import com.github.pagehelper.PageInfo;
import com.example.genshinstart_backend.domain.TaskExam;
import com.example.genshinstart_backend.domain.User;
import com.example.genshinstart_backend.viewmodel.admin.task.TaskPageRequestVM;
import com.example.genshinstart_backend.viewmodel.admin.task.TaskRequestVM;

import java.util.List;

public interface TaskExamService extends BaseService<TaskExam> {

    PageInfo<TaskExam> page(TaskPageRequestVM requestVM);

    void edit(TaskRequestVM model, User user);

    TaskRequestVM taskExamToVM(Integer id);

    List<TaskExam> getByGradeLevel(Integer gradeLevel);
}
