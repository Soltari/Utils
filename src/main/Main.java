package main;

import translation.T;

public class Main
{
	public static void main(String[] args)
	{
		/*
		 * Try to translate "key" using the en_EN file or the es_ES one (if the default language is English or Spanish).
		 */
		System.out.println(T.t("key"));

		/*
		 * Try to translate "key" using the default file, since "shalala" doesn't exist in a specific language file.
		 */
		System.out.println(T.t("shalala"));

		/*
		 * This will return an empty string since "dummy" is not a key in any language file nor in the default one.
		 */
		System.out.println(T.t("dummy"));
	}
}
