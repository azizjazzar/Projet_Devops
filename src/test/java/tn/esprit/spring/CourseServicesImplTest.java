package tn.esprit.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.services.CourseServicesImpl;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CourseServicesImplTest {

    @Mock
    private ICourseRepository courseRepository;

    @InjectMocks
    private CourseServicesImpl courseServices;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }




    // Test de la méthode recommendCoursesForUser
    @Test
     void testRecommendCoursesForUser() {
        Course course1 = new Course();
        course1.setLevel(1); // Niveau débutant

        Course course2 = new Course();
        course2.setLevel(3); // Niveau avancé

        when(courseRepository.findAll()).thenReturn(Arrays.asList(course1, course2));

        // Cas où l'utilisateur a un niveau intermédiaire (niveau 2)
        List<Course> recommendedCourses = courseServices.recommendCoursesForUser(2);

        assertNotNull(recommendedCourses);
        assertEquals(1, recommendedCourses.size()); // Seulement le cours 1 (débutant) est recommandé
        verify(courseRepository, times(1)).findAll();
    }



    // Test de la méthode calculateTotalCourseHours
    @Test
     void testCalculateTotalCourseHours() {
        Course course1 = new Course();
        course1.setTimeSlot(3);

        Course course2 = new Course();
        course2.setTimeSlot(5);

        when(courseRepository.findAll()).thenReturn(Arrays.asList(course1, course2));

        int totalHours = courseServices.calculateTotalCourseHours();

        assertEquals(8, totalHours); // Vérifie que la durée totale est de 8 heures
        verify(courseRepository, times(1)).findAll();
    }



}
