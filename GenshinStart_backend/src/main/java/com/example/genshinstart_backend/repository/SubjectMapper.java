package com.example.genshinstart_backend.repository;

import com.example.genshinstart_backend.domain.Subject;
import com.example.genshinstart_backend.viewmodel.admin.education.SubjectPageRequestVM;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {

    List<Subject> getSubjectByLevel(Integer level);

    List<Subject> allSubject();

    List<Subject> page(SubjectPageRequestVM requestVM);
}
