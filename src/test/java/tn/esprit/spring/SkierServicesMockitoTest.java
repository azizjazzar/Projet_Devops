//package tn.esprit.spring;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import tn.esprit.spring.entities.Skier;
//import tn.esprit.spring.repositories.ICourseRepository;
//import tn.esprit.spring.repositories.IRegistrationRepository;
//import tn.esprit.spring.repositories.ISkierRepository;
//import tn.esprit.spring.services.SkierServicesImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.when;
//
//public class SkierServicesMockitoTest {
//
//    @InjectMocks
//    private SkierServicesImpl skierServices;
//
//    @Mock
//    private ISkierRepository skierRepository;
//    @Mock
//    private ICourseRepository courseRepository;
//    @Mock
//    private IRegistrationRepository registrationRepository;
//
//    @BeforeEach
//    public void init() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testRetrieveAllSkiers_NoSkiersFound() {
//        List<Skier> skiers = new ArrayList<>();
//        when(skierRepository.findAll()).thenReturn(skiers);
//        List<Skier> result = skierServices.retrieveAllSkiers();
//        assertTrue(result.isEmpty());
//    }
//}
