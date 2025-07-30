package com.myapp.spring.controller;

import com.myapp.spring.domain.Instrument;
import com.myapp.spring.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instrument")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @GetMapping
    public ResponseEntity<List<Instrument>> getInstruments() {
        return ResponseEntity.ok(instrumentService.getAllInstruments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrument> getInstrumentById(@PathVariable Long id) {
        Optional<Instrument> instrument = instrumentService.getInstrumentById(id);
        if (!instrument.isPresent()) {
            return null;
        }
        return ResponseEntity.ok(instrument.get());
    }

    @PostMapping
    public ResponseEntity<Instrument> createInstrument(@RequestBody Instrument instrument) {
        return ResponseEntity.ok(instrumentService.addInstrument(instrument));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Instrument> updateInstrument(@PathVariable Long id, @RequestBody Instrument instrument) {
        return ResponseEntity.ok(instrumentService.updateInstrument(id, instrument));
    }

    @DeleteMapping
    public ResponseEntity<Instrument> deleteInstrumentById(@PathVariable Long id) {
        Optional<Instrument> instrument = instrumentService.getInstrumentById(id);
        if (!instrument.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Instrument toDelete = instrument.get();
        instrumentService.deleteInstrument(toDelete);
        return ResponseEntity.ok(toDelete);
    }
}
