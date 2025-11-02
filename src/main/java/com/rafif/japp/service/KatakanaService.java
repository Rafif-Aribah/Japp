package com.rafif.japp.service;

import com.rafif.japp.model.Katakana;
import com.rafif.japp.model.Type;
import com.rafif.japp.repository.KatakanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KatakanaService {

    @Autowired
    KatakanaRepository katakanaRepository;

    public List<Katakana> getAllKatakana() {
        return katakanaRepository.findAll();
    }

    public Katakana getKatakanaById(Integer id) {
        return katakanaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Katakana not found with id: " + id));
    }

    // Get hiragana by character
    public Katakana getKatakanaByCharacter(String hiragana) {
        return katakanaRepository.findByKatakana(hiragana)
                .orElseThrow(() -> new RuntimeException("Katakana not found: " + hiragana));
    }

    // Get hiragana by romaji
    public Katakana getKatakanaByRomaji(String romaji) {
        return katakanaRepository.findByRomaji(romaji)
                .orElseThrow(() -> new RuntimeException("Katakana not found with romaji: " + romaji));
    }

    // Get hiragana by category
    public List<Katakana> getKatakanaByCategory(String category) {
        return katakanaRepository.findByCategory(category);
    }

    // Get hiragana by type
    public List<Katakana> getKatakanaByType(Type type) {
        return katakanaRepository.findByType(type);
    }

    // Get hiragana by category and type
    public List<Katakana> getKatakanaByCategoryAndType(String category, Type type) {
        return katakanaRepository.findByCategoryAndType(category, type);
    }
}
