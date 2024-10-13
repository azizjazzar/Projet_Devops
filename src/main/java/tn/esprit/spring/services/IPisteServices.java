package tn.esprit.spring.services;

import tn.esprit.spring.entities.Color;
import tn.esprit.spring.entities.Piste;

import java.util.List;
import java.util.Map;

public interface IPisteServices {

    List<Piste> retrieveAllPistes();

    Piste addPiste(Piste piste);

    void removePiste(Long numPiste);

    Piste retrievePiste(Long numPiste);

    List<Piste> findPistesByMinLengthAndMinSlope(int minLength, int minSlope);

    double getAverageLengthOfPistes();

    Map<Color, Long> countPistesByColor();
}
