package com.skala.basic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skala.basic.data.CourseResponse;
import com.skala.basic.data.HelloRequest;
import com.skala.basic.data.HelloResponse;
import com.skala.basic.service.CourseService;
import com.skala.basic.service.HelloService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequiredArgsConstructor
public class HelloController {

  private final HelloService helloService;
  private final CourseService courseService;

  @GetMapping("/hello")
  public HelloResponse getHello(@RequestParam String name, @RequestParam int age) { 
      log.debug("getHello: name={}, age={}", name, age);
      log.info("getHello: name={}, age={}", name, age);
      log.error("getHello: name={}, age={}", name, age);
      // HelloService helloService = new HelloService();
      HelloResponse response = helloService.createMessage(name, age);
      

      return response; 
  }
  
  @PostMapping("/hello")
  public HelloResponse postHellp(@RequestBody HelloRequest body) {
      HelloResponse response = helloService.createMessage(body.getName(), 25);
      return response;
  }
  

  /* @GetMapping("/hello")
  public HelloResponse hello(@RequestParam(defaultValue = "SKALA") String name) {
    // 서비스 호출하여 응답 객체 생성
    log.info("/hello: GET {}", name);
    return helloService.createMessage(name);
  } */

  /* @PostMapping("/hello")
  public HelloResponse postHello(@Valid @RequestBody HelloRequest body) {
    log.info("/hello: POST {}", body.getName());
    return helloService.createMessage(body.getName());
  } */

  @PostMapping("/courses/{name}") 
  public CourseResponse getClassInfo(@PathVariable String name, @RequestParam List<String> topics) {
    // Service에서 CourseResponse 생성
    log.info("/courses: {}", name);
    return courseService.createCourse(name, topics);
  }
}
