package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Color;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.services.IPisteServices;

import java.util.List;
import java.util.Map;

@Tag(name = "\uD83C\uDFBF Piste Management")
@RestController
@RequestMapping("/piste")
@RequiredArgsConstructor
public class PisteRestController {

    private final IPisteServices pisteServices;

    // CRUD operations

    @Operation(description = "Add Piste")
    @PostMapping("/add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteServices.addPiste(piste);
    }

    @Operation(description = "Retrieve all Pistes")
    @GetMapping("/all")
    public List<Piste> getAllPistes() {
        return pisteServices.retrieveAllPistes();
    }

    @Operation(description = "Retrieve Piste by Id")
    @GetMapping("/get/{id-piste}")
    public Piste getById(@PathVariable("id-piste") Long numPiste) {
        return pisteServices.retrievePiste(numPiste);
    }

    @Operation(description = "Delete Piste by Id")
    @DeleteMapping("/delete/{id-piste}")
    public void deleteById(@PathVariable("id-piste") Long numPiste) {
        pisteServices.removePiste(numPiste);
    }

    // New functionalities

    @Operation(description = "Retrieve pistes by minimum length and slope")
    @GetMapping("/filter")
    public List<Piste> getPistesByMinLengthAndMinSlope(@RequestParam int minLength, @RequestParam int minSlope) {
        return pisteServices.findPistesByMinLengthAndMinSlope(minLength, minSlope);
    }

    @Operation(description = "Get the average length of all pistes")
    @GetMapping("/average-length")
    public double getAverageLength() {
        return pisteServices.getAverageLengthOfPistes();
    }

    @Operation(description = "Count pistes by color")
    @GetMapping("/count-by-color")
    public Map<Color, Long> countPistesByColor() {
        return pisteServices.countPistesByColor();
    }
}
