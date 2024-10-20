package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Color;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.repositories.IPisteRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PisteServicesImpl implements IPisteServices {

    private final IPisteRepository pisteRepository;

    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public void removePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    // Methode pour les test unitaires
    public double getAverageLengthOfPistes() {
        return pisteRepository.findAll().stream()
                .mapToInt(Piste::getLength)
                .average()
                .orElse(0.0);
    }

    public Map<Color, Long> countPistesByColor() {
        return pisteRepository.findAll().stream()
                .collect(Collectors.groupingBy(Piste::getColor, Collectors.counting()));
    }


}
