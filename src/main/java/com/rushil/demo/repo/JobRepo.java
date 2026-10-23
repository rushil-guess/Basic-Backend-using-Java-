package com.rushil.demo.repo;

import com.rushil.demo.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job,Integer> {

    List<Job> findByExperienceContainingOrSkillsContainingIgnoreCase(String Experience,String Skills);

    Page<Job> findByExperienceGreaterThan(int id, Pageable pageable);  //for pagination
}
//List<Job> jobs = new ArrayList<>(Arrays.asList(
//        new Job(101, "Backend Developer", 3,
//                Arrays.asList("Java", "Spring Boot", "PostgreSQL")),
//        new Job(102, "Frontend Developer", 2,
//                Arrays.asList("JavaScript", "React", "CSS")),
//        new Job(103, "Data Engineer", 5,
//                Arrays.asList("Python", "SQL", "Apache Spark")),
//        new Job(104, "DevOps Engineer", 4,
//                Arrays.asList("AWS", "Docker", "Kubernetes")),
//        new Job(105, "QA Engineer", 1,
//                Arrays.asList("Selenium", "JUnit", "Postman"))
//));
//
//
//public List<Job> getAllJobs() {
//    return jobs;
//}
//
//public Job getjob(int id) {
//    for(Job j:jobs) {
//        if (j.getJobId() == id) {
//            return j;
//        }
//    }
//    return null;
//}
//public void addjob(Job job) {
//    jobs.add(job);
//}
//
//public void update(Job job) {
//    for(Job j:jobs) {
//        if (j.getJobId() == job.getJobId()) {
//            j.setExperience(job.getExperience());
//            j.setJobDesc(job.getJobDesc());
//            j.setSkills(job.getSkills());
//        }}
//}
//
//public void delete(int id) {
//    for(Job j:jobs){
//        if(j.getJobId()==id){
//            jobs.remove(j);
//            break;
//        }
//    }
//}