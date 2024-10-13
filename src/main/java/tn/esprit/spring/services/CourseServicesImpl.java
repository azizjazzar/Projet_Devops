package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.repositories.ICourseRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class CourseServicesImpl implements  ICourseServices{

    private ICourseRepository courseRepository;

    @Override
    public List<Course> retrieveAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course retrieveCourse(Long numCourse) {
        return courseRepository.findById(numCourse).orElse(null);
    }



   
    public List<Course> recommendCoursesForUser(int userLevel) {
        return courseRepository.findAll().stream()
                .filter(course -> course.getLevel() <= userLevel)
                .toList();
    }




    public int calculateTotalCourseHours() {
        return courseRepository.findAll().stream()
                .mapToInt(Course::getTimeSlot)
                .sum();
    }
    
    


}
