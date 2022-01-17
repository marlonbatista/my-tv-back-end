package br.com.mytv.appbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mytv.appbackend.model.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
