package br.com.mytv.appbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mytv.appbackend.model.Plataform;

public interface PlataformRepository extends JpaRepository<Plataform, Integer> {

}
