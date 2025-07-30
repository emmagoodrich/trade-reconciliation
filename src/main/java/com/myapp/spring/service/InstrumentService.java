package com.myapp.spring.service;

import com.myapp.spring.domain.Instrument;

import java.util.List;
import java.util.Optional;

public interface InstrumentService {

    List<Instrument> getAllInstruments();
    Optional<Instrument> getInstrumentById(Long id);
    Instrument updateInstrument(Long id, Instrument instrument);
    Instrument addInstrument(Instrument instrument);
    void deleteInstrument(Instrument instrument);
}
