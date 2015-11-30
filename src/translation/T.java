package translation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Translation Java service used to translate strings depending on the platform language.
 * @author Alberto Hernández Chillón
 * @email alberto.hernandez1@um.es
 */
public class T
{
	/**
	 * Singleton instance.
	 */
	private static T translator = null;

	/**
	 * HashMap used to store key, value pairs of the language file.
	 */
	private Map<String, String> theLanguageMap = null;

	/**
	 * HashMap used to store (key, value) pairs of the default file.
	 */
	private Map<String, String> theDefaultMap = null;

	private final static String RESOURCE_FOLDER = "/resources/";

	private final static String DEFAULT_RESOURCE = "default";

	/**
	 * Private constructor.
	 */
	private T()
	{
		// Read the default translation map and the language translation map.
		theLanguageMap = new HashMap<String, String>();
		theDefaultMap = new HashMap<String, String>();

		URL theLanguageResource = T.class.getResource(RESOURCE_FOLDER + Locale.getDefault());
		URL theDefaultResource = T.class.getResource(RESOURCE_FOLDER + DEFAULT_RESOURCE);

		try
		{
			BufferedReader in = new BufferedReader(new FileReader(theLanguageResource.getFile()));
	        String s;

	        while ((s = in.readLine()) != null)
	        {
	            String parts[] = s.split("=");
	            theLanguageMap.put(parts[0], parts[1]);
	        }
	        in.close();

			in = new BufferedReader(new FileReader(theDefaultResource.getFile()));

	        while ((s = in.readLine()) != null)
	        {
	            String parts[] = s.split("=");
	            theDefaultMap.put(parts[0], parts[1]);
	        }
	        in.close();

		} catch (NullPointerException | IOException e)
		{
			String errMessage = "Error while reading resource translation file: ";

			if (theLanguageResource == null)
				errMessage += "Translation file couldn't be loaded or parsed correctly. ";

			if (theDefaultResource == null)
				errMessage += "Default translation file couldn't be loaded or parsed correctly.";

			System.err.println(errMessage);
		}
	}

	/**
	 * Public method used to translate just by invoking T.t(String).
	 * @param key The key to be translated.
	 * @return A String value, or an empty String if the key didn't exist.
	 */
	public static String t(String key)
	{
		if (translator == null)
			translator = new T();

		return translator.translate(key);
	}

	/**
	 * Private translate method which will try to translate first from the language map.
	 * If that translation didn't go well, try to translate using the default language file.
	 * @param key The key to be translated.
	 * @return A String value, or an empty String if the key didn't exist.
	 */
	private String translate(String key)
	{
		String result = theLanguageMap.get(key);

		if (result != null)
			return result;

		result = theDefaultMap.get(key);

		return result != null ? result : "";
	}
}
