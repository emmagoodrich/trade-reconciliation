package com.myapp.spring.service;

import com.myapp.spring.domain.Instrument;
import com.myapp.spring.repository.InstrumentRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstrumentServiceImpl implements InstrumentService {

    private InstrumentRepository instrumentRepository;

    public InstrumentServiceImpl(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    @Override
    @Cacheable(value = "instrument",key = "#instrumentId")
    public Optional<Instrument> getInstrumentById(Long instrumentId) {
        return instrumentRepository.findById(instrumentId);
    }

    @Override
    public Instrument updateInstrument(Long id, Instrument instrument) {
        Optional<Instrument> toUpdate = instrumentRepository.findById(id);
        if (!toUpdate.isPresent()) {
            return null;
        }
        Instrument updatedInstrument = toUpdate.get();
        updatedInstrument.setName(instrument.getName());
        updatedInstrument.setSymbol(instrument.getSymbol());
        updatedInstrument.setIsin(instrument.getIsin());
        return instrumentRepository.save(updatedInstrument);
    }

    @Override
    public Instrument addInstrument(Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    @Override
    public void deleteInstrument(Instrument instrument) {
        instrumentRepository.delete(instrument);
    }
}
