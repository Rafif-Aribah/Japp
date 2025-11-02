package com.rafif.japp.repository;

import com.rafif.japp.model.Hiragana;
import com.rafif.japp.model.Katakana;
import com.rafif.japp.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KatakanaRepository extends JpaRepository<Katakana, Integer> {
    Optional<Katakana> findByKatakana(String hiragana);
    Optional<Katakana> findByRomaji(String romaji);

    List<Katakana> findByCategory(String category);
    List<Katakana> findByType(Type type);
    List<Katakana> findByCategoryAndType(String category, Type type);
}
