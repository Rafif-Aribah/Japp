package com.rafif.japp.service;

import com.rafif.japp.model.Hiragana;
import com.rafif.japp.model.Type;
import com.rafif.japp.repository.HiraganaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HiraganaService {

    @Autowired
    private HiraganaRepository hiraganaRepository;

    public List<Hiragana> getAllHiragana() {
        return hiraganaRepository.findAll();
    }

    // Get hiragana by ID
    public Hiragana getHiraganaById(Integer id) {
        return hiraganaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hiragana not found with id: " + id));
    }

    // Get hiragana by character
    public Hiragana getHiraganaByCharacter(String hiragana) {
        return hiraganaRepository.findByHiragana(hiragana)
                .orElseThrow(() -> new RuntimeException("Hiragana not found: " + hiragana));
    }

    // Get hiragana by romaji
    public Hiragana getHiraganaByRomaji(String romaji) {
        return hiraganaRepository.findByRomaji(romaji)
                .orElseThrow(() -> new RuntimeException("Hiragana not found with romaji: " + romaji));
    }

    // Get hiragana by category
    public List<Hiragana> getHiraganaByCategory(String category) {
        return hiraganaRepository.findByCategory(category);
    }

    // Get hiragana by type
    public List<Hiragana> getHiraganaByType(Type type) {
        return hiraganaRepository.findByType(type);
    }

    // Get hiragana by category and type
    public List<Hiragana> getHiraganaByCategoryAndType(String category, Type type) {
        return hiraganaRepository.findByCategoryAndType(category, type);
    }

}
