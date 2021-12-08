import java.io.FileInputStream
import java.io.IOException
import java.util.*

object UtilResources {
    private var properties: Properties? = null

    fun loadProperties(): Unit {
        try {
            properties = Properties()
            properties?.load(FileInputStream("config.properties"))

            var secretprops = Properties()
            secretprops?.load(FileInputStream("secret.properties"))

            properties?.putAll(secretprops)

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getProperties(properties: String): String {
        loadProperties()
        return UtilResources.properties?.getProperty(properties).toString()
    }
}