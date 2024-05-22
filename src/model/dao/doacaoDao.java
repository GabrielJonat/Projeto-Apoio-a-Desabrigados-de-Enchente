package model.dao;

import java.util.List;

import model.entities.Doacao;

public interface doacaoDao<CentroDistribuicao> {
	
	void insert(Doacao obj);
	void update(Integer id, String nome);
	void deleteById(Integer id);
	Doacao findById(Integer id);
	List<Doacao> findAll();
	List<Doacao> findBycentroDistribuicao(CentroDistribuicao centroDistribuicao);

}
