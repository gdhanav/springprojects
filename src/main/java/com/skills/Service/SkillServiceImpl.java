package com.skills.Service;

import com.skills.model.Employee;
import com.skills.model.Skill;
import com.skills.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillRepository skillRepository;

    @Override
    public Skill save(Skill skill) throws Exception {
        return skillRepository.save(skill);
    }

    @Override
    public Skill delete(Skill skill) throws Exception {
        try{
            skillRepository.delete(skill);
        }catch(Exception ex){
            System.out.println("Error when delete employee");
            ex.printStackTrace();
        }
        return skill;
    }

    @Override
    public Skill findById(long id) throws Exception {
        Optional<Skill> skill= skillRepository.findById(id);
        skill.orElseThrow(()-> new Exception("Employee Not Found"));
        return skill.get();
    }

    public List<Skill> findAll() throws Exception{
        return skillRepository.findAll();
    }
}
