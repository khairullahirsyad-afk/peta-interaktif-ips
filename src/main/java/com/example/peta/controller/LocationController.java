package com.example.peta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.peta.model.Lokasi;
import com.example.peta.repository.LokasiRepository;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LokasiRepository lokasiRepository;

    // 🌍 1. Menampilkan halaman utama (index.html)
    @GetMapping("/")
    public String index(Model model) {
        List<Lokasi> lokasiList = lokasiRepository.findAll();
        model.addAttribute("lokasiList", lokasiList);
        return "index"; // templates/index.html
    }

    // 💾 2. Menyimpan lokasi ke database (ketika klik di peta)
    @PostMapping("/tambah-lokasi")
    @ResponseBody
    public void tambahLokasi(@RequestBody Lokasi lokasi) {
        lokasiRepository.save(lokasi);
    }

    // 🔔 3. Broadcast lokasi baru ke semua pengguna lewat WebSocket
    @MessageMapping("/addLocation")
    @SendTo("/topic/locations")
    public Lokasi kirimLokasi(Lokasi lokasi) {
        System.out.println("Lokasi baru: " + lokasi.getNama());
        return lokasi;
    }
}
