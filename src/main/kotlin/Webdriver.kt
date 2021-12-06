import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import java.net.URI
import java.util.concurrent.TimeUnit

lateinit var driver: WebDriver
    private set

fun main(args: Array<String>) {

    println("Hello")
    setup()

}


fun setup() {
    System.setProperty(UtilResources.getProperties("nameDriver"),
        UtilResources.getProperties("pathDriver") + UtilResources.getProperties("exeDriver"))
    driver = ChromeDriver()
    driver?.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
    driver?.manage()?.window()?.maximize()
    driver?.get(URI("https://www.youtube.com/").toString())
}