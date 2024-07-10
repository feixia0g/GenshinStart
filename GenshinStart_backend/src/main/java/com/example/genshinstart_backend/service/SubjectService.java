package com.example.genshinstart_backend.service;

import com.github.pagehelper.PageInfo;
import com.example.genshinstart_backend.domain.Subject;
import com.example.genshinstart_backend.viewmodel.admin.education.SubjectPageRequestVM;

import java.util.List;

public interface SubjectService extends BaseService<Subject> {

    List<Subject> getSubjectByLevel(Integer level);

    List<Subject> allSubject();

    Integer levelBySubjectId(Integer id);

    PageInfo<Subject> page(SubjectPageRequestVM requestVM);
}
