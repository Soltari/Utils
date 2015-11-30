**-* Utils - Java Translation Service *-** 

This Java Translation Service loads some (key, value) files and uses a simple API to translate Strings from a generic key to a platform language specific value. In other words, it translates in a different way a "key" String depending if the machine is being executed under "es_ES" language or "en_EN", for example. It also uses a default file

# This package contains the following items:

* src/main: A Main class which can be executed to show some translation examples.
* src/resources: A folder containing some Resource files for es_ES and en_EN, as well as a default file language.
* src/translation: The Translation service class itself.

# Usage:

* Get src/translation/T.java
* Make sure you have a "Resources" package containing some language specific keys like the "resources" package example provided.
* Each time you want to translate a String, call T.t(String).
* The string will be translated using the default language platform you are working with. If this is not possible, the default language file will be used. If this is not possible, an empty string will be returned.
* That's all! For a complete example please refer to src/main/Main.java.