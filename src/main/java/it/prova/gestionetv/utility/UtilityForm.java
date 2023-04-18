package it.prova.gestionetv.utility;

public class UtilityForm {

	public static Integer integerParseFromString(String input) {
		Integer result = null;
		try {
			result = Integer.parseInt(input);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public static Double doubleParseFromString(String input) {
		Double result = null;
		try {
			result = Double.parseDouble(input);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
