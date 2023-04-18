package it.prova.gestionetv.dao.televisore;

import java.util.ArrayList;
import java.util.List;

import it.prova.gestionetv.dao.DB_Mock;
import it.prova.gestionetv.dao.EntityManagerMock;
import it.prova.gestionetv.model.Televisore;

public class TelevisoreDAOImpl implements TelevisoreDAO {

	private EntityManagerMock entityManager;
	
	@Override
	public List<Televisore> findByMarcaAndModello(String marca, String modello) {
		List<Televisore> result = new ArrayList<>();
		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if (televisoreItem.getMarca().startsWith(marca) && televisoreItem.getModello().startsWith(modello)) {
				result.add(televisoreItem);
			}
		}
		return result;
	}

	@Override
	public List<Televisore> list() throws Exception {
		List<Televisore> result = new ArrayList<>();
		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			result.add(televisoreItem);
		}
		return result;
	}

	@Override
	public Televisore get(Long id) throws Exception {

		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if (televisoreItem.getIdTelevisore() == id) {
				return televisoreItem;
			}
		}
		return null;
	}

	@Override
	public int update(Televisore input) throws Exception {
		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if(televisoreItem.getIdTelevisore().equals(input.getIdTelevisore())) {
				televisoreItem.setMarca(input.getMarca());
				televisoreItem.setModello(input.getModello());
				televisoreItem.setPrezzo(input.getPrezzo());
				televisoreItem.setNumeroPollici(input.getNumeroPollici());
				televisoreItem.setCodice(input.getCodice());
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int insert(Televisore input) throws Exception {
		input.setIdTelevisore(DB_Mock.getNexIdAvailable());
		return DB_Mock.LISTA_TELEVISORI.add(input) ? 1 : 0;
	}

	@Override
	public int delete(Long idToRemove) throws Exception {
		List<Televisore> listaNuova = new ArrayList<>();
		int result = 0;
		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if(!televisoreItem.getIdTelevisore().equals(idToRemove)) {
				listaNuova.add(televisoreItem);
			} else {
				result++;
			}
		}
		DB_Mock.LISTA_TELEVISORI.clear();
		DB_Mock.LISTA_TELEVISORI.addAll(listaNuova);
		return result;
	}

	@Override
	public void setEntityManager(EntityManagerMock entityManager) {
		this.entityManager = entityManager;

	}

}
