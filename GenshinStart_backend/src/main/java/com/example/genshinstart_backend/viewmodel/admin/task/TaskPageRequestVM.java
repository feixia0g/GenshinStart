package com.example.genshinstart_backend.viewmodel.admin.task;

import com.example.genshinstart_backend.base.BasePage;


public class TaskPageRequestVM extends BasePage {
    private Integer gradeLevel;

    public Integer getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
}
