package com.skills.Service;

import com.skills.model.Skill;

import java.util.List;

public interface SkillService {

    Skill save(Skill skill) throws Exception;
    Skill delete(Skill skill) throws Exception;
    Skill findById(long id) throws Exception;
    List<Skill> findAll() throws Exception;
}
