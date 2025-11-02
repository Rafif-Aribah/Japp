package com.rafif.japp.controller;


import com.rafif.japp.model.Katakana;
import com.rafif.japp.model.Type;
import com.rafif.japp.service.KatakanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/katakana")
public class KatakanaController {
    @Autowired
    KatakanaService katakanaService;

    @GetMapping
    public ResponseEntity<List<Katakana>> getAllKatakana() {
        List<Katakana> hiraganaList = katakanaService.getAllKatakana();
        return ResponseEntity.ok(hiraganaList);
    }

    // GET hiragana by ID
    @GetMapping("/{id}")
    public ResponseEntity<Katakana> getKatakanaById(@PathVariable Integer id) {
        Katakana hiragana = katakanaService.getKatakanaById(id);
        return ResponseEntity.ok(hiragana);
    }

    // GET hiragana by character
    @GetMapping("/character/{hiragana}")
    public ResponseEntity<Katakana> getKatakanaByCharacter(@PathVariable String hiragana) {
        Katakana result = katakanaService.getKatakanaByCharacter(hiragana);
        return ResponseEntity.ok(result);
    }

    // GET hiragana by romaji
    @GetMapping("/romaji/{romaji}")
    public ResponseEntity<Katakana> getKatakanaByRomaji(@PathVariable String romaji) {
        Katakana hiragana = katakanaService.getKatakanaByRomaji(romaji);
        return ResponseEntity.ok(hiragana);
    }

    // GET hiragana by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Katakana>> getKatakanaByCategory(@PathVariable String category) {
        List<Katakana> hiraganaList = katakanaService.getKatakanaByCategory(category);
        return ResponseEntity.ok(hiraganaList);
    }

    // GET hiragana by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Katakana>> getKatakanaByType(@PathVariable Type type) {
        List<Katakana> hiraganaList = katakanaService.getKatakanaByType(type);
        return ResponseEntity.ok(hiraganaList);
    }

    // GET hiragana by category and type
    @GetMapping("/filter")
    public ResponseEntity<List<Katakana>> getKatakanaByCategoryAndType(
            @RequestParam String category,
            @RequestParam Type type) {
        List<Katakana> hiraganaList = katakanaService.getKatakanaByCategoryAndType(category, type);
        return ResponseEntity.ok(hiraganaList);
    }

}
