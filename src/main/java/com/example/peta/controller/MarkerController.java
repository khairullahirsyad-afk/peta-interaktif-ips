package com.example.map;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/markers")
public class MarkerController {

    private final MarkerRepository repo;

    public MarkerController(MarkerRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Marker> getMarkers() {
        return repo.findAll();
    }

    @PostMapping
    public Marker addMarker(@RequestBody Marker marker) {
        return repo.save(marker);
    }
}
