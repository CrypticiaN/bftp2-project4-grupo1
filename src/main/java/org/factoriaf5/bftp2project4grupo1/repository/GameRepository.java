package org.factoriaf5.bftp2project4grupo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findGamesByTitleContaining(String word);
    List<Game> findGamesByCategoryEquals(String category);
    List<Game> findGamesByPegiEquals(String pegi);
    List<Game> findGamesByPriceWithDiscount(double price);

}


