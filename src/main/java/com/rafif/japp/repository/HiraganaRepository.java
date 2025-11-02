package com.rafif.japp.repository;

import com.rafif.japp.model.Hiragana;
import com.rafif.japp.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HiraganaRepository extends JpaRepository<Hiragana, Integer> {
    Optional<Hiragana> findByHiragana(String hiragana);
    Optional<Hiragana> findByRomaji(String romaji);

    List<Hiragana> findByCategory(String category);
    List<Hiragana> findByType(Type type);
    List<Hiragana> findByCategoryAndType(String category, Type type);
}
