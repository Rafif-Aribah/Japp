package com.rafif.japp.controller;


import com.rafif.japp.model.Hiragana;
import com.rafif.japp.model.Type;
import com.rafif.japp.service.HiraganaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hiragana")
public class HiraganaController {

    private final HiraganaService hiraganaService;

    public HiraganaController(HiraganaService hiraganaService) {
        this.hiraganaService = hiraganaService;
    }

    // GET all hiragana
    @GetMapping
    public ResponseEntity<List<Hiragana>> getAllHiragana() {
        List<Hiragana> hiraganaList = hiraganaService.getAllHiragana();
        return ResponseEntity.ok(hiraganaList);
    }

    // GET hiragana by ID
    @GetMapping("/{id}")
    public ResponseEntity<Hiragana> getHiraganaById(@PathVariable Integer id) {
        Hiragana hiragana = hiraganaService.getHiraganaById(id);
        return ResponseEntity.ok(hiragana);
    }

    // GET hiragana by character
    @GetMapping("/character/{hiragana}")
    public ResponseEntity<Hiragana> getHiraganaByCharacter(@PathVariable String hiragana) {
        Hiragana result = hiraganaService.getHiraganaByCharacter(hiragana);
        return ResponseEntity.ok(result);
    }

    // GET hiragana by romaji
    @GetMapping("/romaji/{romaji}")
    public ResponseEntity<Hiragana> getHiraganaByRomaji(@PathVariable String romaji) {
        Hiragana hiragana = hiraganaService.getHiraganaByRomaji(romaji);
        return ResponseEntity.ok(hiragana);
    }

    // GET hiragana by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Hiragana>> getHiraganaByCategory(@PathVariable String category) {
        List<Hiragana> hiraganaList = hiraganaService.getHiraganaByCategory(category);
        return ResponseEntity.ok(hiraganaList);
    }

    // GET hiragana by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Hiragana>> getHiraganaByType(@PathVariable Type type) {
        List<Hiragana> hiraganaList = hiraganaService.getHiraganaByType(type);
        return ResponseEntity.ok(hiraganaList);
    }

    // GET hiragana by category and type
    @GetMapping("/filter")
    public ResponseEntity<List<Hiragana>> getHiraganaByCategoryAndType(
            @RequestParam String category,
            @RequestParam Type type) {
        List<Hiragana> hiraganaList = hiraganaService.getHiraganaByCategoryAndType(category, type);
        return ResponseEntity.ok(hiraganaList);
    }
}
