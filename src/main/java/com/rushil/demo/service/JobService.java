package com.rushil.demo.service;

import com.rushil.demo.model.Job;
import com.rushil.demo.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public List<Job> getAlljobs() {
        return repo.findAll();
    }

    public Job getjob(int id) {
        return repo.findById(id).orElse(new Job());
    }

    public void addjob(Job job) {
        repo.save(job);
    }

    public void update(Job job) {
        repo.save(job);
    }

    public void delete(int id) {
        repo.deleteAllById(Collections.singleton(id));
    }

    public List<Job> search(String keyword) {
        return repo.findByExperienceContainingOrSkillsContainingIgnoreCase(keyword, keyword);
    }

    public void page() {
        Page<Job> highScorers = repo.findByExperienceGreaterThan(3, PageRequest.of(0, 5));
    }

    public void addjobwithimage(Job job, MultipartFile imagefile) throws IOException {
        job.setImagedata(imagefile.getBytes());
        job.setContentType(imagefile.getContentType());
        job.setImageName(imagefile.getName());
        repo.save(job);
    }

    public byte[] jobwithimage(int id) {
        Job j=repo.findById(id).orElse(new Job());
        return j.getImagedata();
    }
}
