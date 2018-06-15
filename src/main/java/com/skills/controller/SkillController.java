package com.skills.controller;

import com.skills.Service.SkillService;
import com.skills.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/skill")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @PostMapping(value="/create")
    private Skill create(@RequestBody Skill skill) throws Exception{
        return skillService.save(skill);
    }
    @GetMapping(value="/read/{id}")
    private Skill findById(@PathVariable long id) throws Exception{
        return skillService.findById(id);
    }
    @PutMapping(value="/upate")
    private Skill upadte(@RequestBody Skill skill) throws Exception{
        return skillService.save(skill);
    }
    @DeleteMapping(value="/delete")
    private Skill delete(@RequestBody Skill skill) throws Exception{
        return skillService.delete(skill);
    }

    @GetMapping(value="/read/All")
    private List<Skill> findAll() throws Exception{
        return skillService.findAll();
    }

}
