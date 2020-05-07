package com.test.springboot.rest.api.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

   public List<Course> getAllCourses(String topicId){
//       return courses;
       List<Course> courses = new ArrayList<>();
       courseRepository.findByTopicId(topicId)
               .forEach(courses::add);
       return courses;
   }

   public Course getCourse(String id){
//       return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
       return courseRepository.findOne(id);
   }

    public void addCourse(Course course) {
//        courses.add(course);
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
//        for(int i=0; i<courses.size(); i++){
//            Course t = courses.get(i);
//            if(t.getId().equals(id)){
//                courses.set(i, course);
//                return;
//            }
//        }
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
//        for(int i=0; i<courses.size(); i++){
//            Course t = courses.get(i);
//            if(t.getId().equals(id)){
//                courses.remove(id);
//                return;
//            }
//        }
//        courses.removeIf(t -> t.getId().equals(id));
        courseRepository.delete(id);
    }
}
