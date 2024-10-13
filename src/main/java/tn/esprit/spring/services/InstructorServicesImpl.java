package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.repositories.IInstructorRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class InstructorServicesImpl implements IInstructorServices{

    private IInstructorRepository instructorRepository;
    private ICourseRepository courseRepository;

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> retrieveAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor retrieveInstructor(Long numInstructor) {
        return instructorRepository.findById(numInstructor).orElse(null);
    }

    @Override
    public Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElse(null);
        Set<Course> courseSet = new HashSet<>();
        courseSet.add(course);
        instructor.setCourses(courseSet);
        return instructorRepository.save(instructor);
    }
// Méthode pour calculer l'ancienneté d'un instructeur
    public int calculateInstructorSeniority(Long numInstructor) {
        Instructor instructor = instructorRepository.findById(numInstructor).orElse(null);
        if (instructor != null && instructor.getDateOfHire() != null) {
            return LocalDate.now().getYear() - instructor.getDateOfHire().getYear();
        }
        return 0;
    }

    //Méthode pour obtenir tous les cours enseignés par un instructeur
    public Set<Course> getCoursesTaughtByInstructor(Long numInstructor) {
        Instructor instructor = instructorRepository.findById(numInstructor).orElse(null);
        if (instructor != null) {
            return instructor.getCourses();
        }
        return new HashSet<>();
    }




}
