package tn.esprit.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.repositories.IRegistrationRepository;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.repositories.ISubscriptionRepository;
import tn.esprit.spring.services.SkierServicesImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SkierServicesTest {
    @InjectMocks
    private SkierServicesImpl skierServices;

    @Mock
    private ISkierRepository skierRepository;
    @Mock
    private ICourseRepository courseRepository;
    @Mock
    private IRegistrationRepository registrationRepository;

    @Mock
    private ISubscriptionRepository subscriptionRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllSkiers_NoSkiersFound() {
        List<Skier> skiers = new ArrayList<>();
        when(skierRepository.findAll()).thenReturn(skiers);

        // Call the method under test
        List<Skier> result = skierServices.retrieveAllSkiers();

        // Verify that the mock was called as expected
        verify(skierRepository).findAll();  // Verifies findAll was called once

        // Additional verification can go here based on desired test logic
    }


    @Test
    public void testAddSkier_WithAnnualSubscription() {
        Skier skier = new Skier();
        Subscription subscription = new Subscription();
        subscription.setTypeSub(TypeSubscription.ANNUAL);
        subscription.setStartDate(LocalDate.now());
        skier.setSubscription(subscription);

        when(skierRepository.save(skier)).thenReturn(skier);

        Skier savedSkier = skierServices.addSkier(skier);

        assertNotNull(savedSkier.getSubscription().getEndDate());
        assertEquals(subscription.getStartDate().plusYears(1), savedSkier.getSubscription().getEndDate());
        verify(skierRepository).save(skier);
    }


    @Test
    public void testAssignSkierToSubscription() {
        Skier skier = new Skier();
        Subscription subscription = new Subscription();

        when(skierRepository.findById(1L)).thenReturn(Optional.of(skier));
        when(subscriptionRepository.findById(1L)).thenReturn(Optional.of(subscription));
        when(skierRepository.save(skier)).thenReturn(skier);

        Skier result = skierServices.assignSkierToSubscription(1L, 1L);

        assertNotNull(result.getSubscription());
        assertEquals(subscription, result.getSubscription());
        verify(skierRepository).save(skier);
    }


    @Test
    public void testAddSkierAndAssignToCourse() {
        Skier skier = new Skier();
        skier.setRegistrations(new HashSet<>());

        Course course = new Course();
        course.setNumCourse(1L);

        Registration registration = new Registration();
        registration.setSkier(skier);
        skier.getRegistrations().add(registration);

        when(courseRepository.getById(1L)).thenReturn(course);
        when(skierRepository.save(skier)).thenReturn(skier);

        Skier savedSkier = skierServices.addSkierAndAssignToCourse(skier, 1L);

        for (Registration r : savedSkier.getRegistrations()) {
            assertEquals(course, r.getCourse());
            verify(registrationRepository).save(r);
        }
        verify(skierRepository).save(skier);
    }












}