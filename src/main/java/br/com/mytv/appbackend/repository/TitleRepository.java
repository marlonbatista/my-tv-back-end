package br.com.mytv.appbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.mytv.appbackend.model.Title;
import br.com.mytv.appbackend.model.enums.Category;

public interface TitleRepository extends JpaRepository<Title, Long> {

    List<Title> findByName(String name);

    List<Title> findByCategory(Category category);

    @Query(value = "SELECT * FROM  public.get_top_four_titles_by_category() ORDER BY CATEGORY DESC", nativeQuery = true)
    List<Title> getTopFourTitlesByCategoList();
}
