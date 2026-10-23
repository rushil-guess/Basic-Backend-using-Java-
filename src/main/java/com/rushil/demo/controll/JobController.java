package com.rushil.demo.controller;

import com.rushil.demo.model.Job;
import com.rushil.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class JobController {
    @Autowired
    private JobService service;

    @GetMapping(path = {"/","home"})
    public ResponseEntity<List<Job>> home(){
        return new ResponseEntity<>(service.getAlljobs(), HttpStatus.OK);
    }
    @GetMapping("getalljobs")
    @ResponseBody
    public ResponseEntity<List<Job>> getalljobs() {
        return new ResponseEntity<>(service.getAlljobs(), HttpStatus.OK);
    }
    @GetMapping(value = "getalljob/{id}",produces = {"application/json"})
    public ResponseEntity<Job> getjob(@PathVariable("id") int id){
        return new ResponseEntity<>(service.getjob(id),HttpStatus.OK);
    }
    @GetMapping("jobwithimage/{id}")
    public ResponseEntity<byte[]> jobwithimage(@PathVariable int id){
        return new ResponseEntity<>(service.jobwithimage(id),HttpStatus.ACCEPTED);

    }
    @PostMapping(value = "getjob",consumes = {"application/xml"})
    public ResponseEntity addjob(@RequestBody Job job){
        service.addjob(job);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PostMapping(value = "getjobwithiamge",consumes = {"application/xml"})
    public ResponseEntity addjobwithimage(@RequestPart Job job, @RequestPart MultipartFile imagefile) throws IOException {
        service.addjobwithimage(job,imagefile);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("updatejob")
    public ResponseEntity updatejob(@RequestBody Job job){
        service.update(job);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("getjob/{id}")
    public ResponseEntity deletejob(@PathVariable("id") int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<Job>> searchJob(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(service.search(keyword),HttpStatus.ACCEPTED);
    }
    @GetMapping("search")
    public ResponseEntity<List<Job>> searchJobwithurlparams(@RequestParam String keyword){
        return new ResponseEntity<>(service.search(keyword),HttpStatus.ACCEPTED);
    }
}
