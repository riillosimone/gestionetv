package it.prova.gestionetv.service.televisore;

import java.util.List;

import it.prova.gestionetv.dao.televisore.TelevisoreDAO;
import it.prova.gestionetv.model.Televisore;

public interface TelevisoreService {

	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO);
	
	public List<Televisore> cercaPerMarcaEModello(String marca, String modello);
	
	public Televisore caricaSingolo(Long id);
	
	public List<Televisore> listaCompleta();
	
	public int inserisciNuovo(Televisore input);
	
	public int elimina(Long idToRemove);
	
	public int aggiorna(Televisore input);
}
