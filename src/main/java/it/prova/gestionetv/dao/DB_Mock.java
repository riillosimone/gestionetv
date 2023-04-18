package it.prova.gestionetv.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import it.prova.gestionetv.model.Televisore;


public class DB_Mock {

	public static final List<Televisore> LISTA_TELEVISORI = new ArrayList<>();

	static {
		// preparo una lista mock perché ancora non ho il collegamento alla
		// base dati
		LISTA_TELEVISORI.add(new Televisore(1l, "LG", "M45O", 200D, 45, "001"));
		LISTA_TELEVISORI.add(new Televisore(2l, "LG", "M65O", 200D, 65, "002"));
		LISTA_TELEVISORI.add(new Televisore(3l, "Apple", "AppleTV", 56D, 25, "003"));
		LISTA_TELEVISORI.add(new Televisore(4l, "Samsung", "qled55", 400D, 55, "004"));
		LISTA_TELEVISORI.add(new Televisore(5l, "Samsung", "Q75led", 800D, 75, "005"));
		LISTA_TELEVISORI.add(new Televisore(6l, "Philips", "OLed%%", 600D, 55, "006"));
		LISTA_TELEVISORI.add(new Televisore(7l, "LG", "C45A", 400D, 45, "007"));
	}

	public static Long getNexIdAvailable() {
		Long resultId = null;
		if (LISTA_TELEVISORI == null || LISTA_TELEVISORI.isEmpty()) {
			resultId = 1L;
		}
		resultId=LISTA_TELEVISORI.stream().max(Comparator.comparing(Televisore::getIdTelevisore)).get().getIdTelevisore();
		return ++resultId;
	}
}
