package org.example.lab04_javaco.service;

import org.example.lab04_javaco.entity.Trailer;
import org.example.lab04_javaco.repository.TrailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrailerService {
    private TrailerRepository trailerRepository;

    @Autowired
    public void TrailerRepository(TrailerRepository trailerRepository) {
        this.trailerRepository = trailerRepository;
    }

    public List<Trailer> getAllTrailer() {
        return trailerRepository.findAll();
    }

    public Optional<Trailer> getTrailerById(Long id) {
        return trailerRepository.findById(id);
    }

    public Trailer saveTrailer(Trailer trailer) {
        return trailerRepository.save(trailer);
    }

    public void deleteDriver(Long id) {
        trailerRepository.deleteById(id);
    }
}
