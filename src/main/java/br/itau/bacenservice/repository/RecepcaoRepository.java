package br.itau.bacenservice.repository;

import br.itau.bacenservice.model.Recepcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecepcaoRepository extends JpaRepository<Recepcao, Integer> {

}
