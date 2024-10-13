package tn.esprit.spring;

import tn.esprit.spring.entities.Color;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.repositories.IPisteRepository;
import tn.esprit.spring.services.PisteServicesImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class PisteServicesImplTest {

    @Mock
    private IPisteRepository pisteRepository;

    @InjectMocks
    private PisteServicesImpl pisteServices;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAverageLengthOfPistes() {
        Piste piste1 = new Piste(1L, "Piste A", Color.BLUE, 500, 15);
        Piste piste2 = new Piste(2L, "Piste B", Color.RED, 600, 20);
        Piste piste3 = new Piste(3L, "Piste C", Color.GREEN, 700, 25);

        when(pisteRepository.findAll()).thenReturn(Arrays.asList(piste1, piste2, piste3));

        double averageLength = pisteServices.getAverageLengthOfPistes();

        assertEquals(600.0, averageLength);
        verify(pisteRepository, times(1)).findAll();
    }

    @Test
    public void testCountPistesByColor() {
        Piste piste1 = new Piste(1L, "Piste A", Color.BLUE, 500, 15);
        Piste piste2 = new Piste(2L, "Piste B", Color.RED, 600, 20);
        Piste piste3 = new Piste(3L, "Piste C", Color.BLUE, 700, 25);

        when(pisteRepository.findAll()).thenReturn(Arrays.asList(piste1, piste2, piste3));

        Map<Color, Long> result = pisteServices.countPistesByColor();

        Map<Color, Long> expected = new HashMap<>();
        expected.put(Color.BLUE, 2L);
        expected.put(Color.RED, 1L);

        assertEquals(expected, result);
        verify(pisteRepository, times(1)).findAll();
    }
}
