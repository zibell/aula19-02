package com.marcelo.aula.apicard.api;



import java.io.Console;
import java.util.List;

import com.marcelo.aula.apicard.resource.Card;

/**
 * {@link CardAPI} is used to fetch {@link Card}s from magicthegathering.io
 * 
 * @author nniklas
 */
public class CardAPI extends MTGAPI {
	private static final String RESOURCE_PATH = "cards";

	/**
	 * @return A {@link Card} based on the given card id
	 */
	public static Card getCard(String cardId) {
		String path = String.format("%s/%s/", RESOURCE_PATH, cardId);
		return get(path, "card", Card.class);
	}
	
	public static Card getCardByName(String cardName) {
		//..cards?name=X
		String path = String.format("%s?name=%s&language=Portuguese (Brazil)", RESOURCE_PATH, cardName);
		
		return getByName(path, "card", Card.class);
	}

	/**
	 * @return A {@link Card} based on the given multiverse id
	 */
	public static Card getCard(int multiverseId) {
		String path = String.format("%s/%s/", RESOURCE_PATH, multiverseId);
		return get(path, "card", Card.class);
	}

	/**
	 * @return All the available {@link Card}s as a list.
	 */
	public static List<Card> getAllCards() {
		return getList(RESOURCE_PATH, "cards", Card.class);
	}

	/**
	 * @return A {@link List} of all card types as {@link String}s.
	 * 
	 * @see <a href="https://docs.magicthegathering.io/#card-types">
	 * 		https://docs.magicthegathering.io/#card-types</a>
	 */
	public static List<String> getAllCardTypes() {
		String path = "types";
		return getList(path, "types", String.class);
	}

	/**
	 * @return A {@link List} of all card types as {@link String}s.
	 *
	 * @see <a href="https://docs.magicthegathering.io/#card-types">
	 * 		https://docs.magicthegathering.io/#get-all-supertypes</a>
	 */
	public static List<String> getAllCardSupertypes() {
		String path = "supertypes";
		return getList(path, "supertypes", String.class);
	}

	/**
	 * @return A {@link List} of all card types as {@link String}s.
	 *
	 * @see <a href="https://docs.magicthegathering.io/#card-types">
	 * 		https://docs.magicthegathering.io/#card-types</a>
	 */
	public static List<String> getAllCardSubtypes() {
		String path = "subtypes";
		return getList(path, "subtypes", String.class);
	}

	/**
	 * Get all the {@link Card} that match a certain filter.
	 * @param filters List of filters supported by the web API
	 * @return List of all matching {@link Card}s.
	 *
	 * @see <a href="https://docs.magicthegathering.io/#cards">
	 *		https://docs.magicthegathering.io/#cards</a>
	 */
	public static List<Card> getAllCards(List<String> filters){
		return getList(RESOURCE_PATH, "cards", Card.class, filters);
	}
}
