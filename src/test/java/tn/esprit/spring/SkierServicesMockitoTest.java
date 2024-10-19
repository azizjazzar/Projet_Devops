package tn.esprit.spring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repositories.*;
import tn.esprit.spring.services.*;

import java.time.LocalDate;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SkierServicesMockitoTest {
    @InjectMocks
    private SkierServicesImpl skierServices;

    @Mock
    private ISkierRepository skierRepository;
    @Mock
    private ICourseRepository courseRepository;
    @Mock
    private IRegistrationRepository registrationRepository;

    private AutoCloseable closeable; // To manage resources for openMocks

    @Before
    public void init() {
        // Use openMocks instead of initMocks and close resources after test
        closeable = MockitoAnnotations.openMocks(this);
    }

    // Make sure to close mocks after the test execution
    @After
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testRetrieveAllSkiers() {
        List<Skier> skiers = new ArrayList<>();
        skiers.add(new Skier(1L, "dhia", "aissa", LocalDate.now(), "Zarzis", new Subscription(), new HashSet<Piste>(), new HashSet<Registration>()));
        skiers.add(new Skier(2L, "wassim", "makther", LocalDate.now(), "Medenine", new Subscription(), new HashSet<Piste>(), new HashSet<Registration>()));
        when(skierRepository.findAll()).thenReturn(skiers);
        List<Skier> result = skierServices.retrieveAllSkiers();
        assertEquals(skiers, result);
    }


}
