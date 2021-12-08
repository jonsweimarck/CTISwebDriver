import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import pages.InitialApplicationPage
import pages.LoginPage
import pages.SummaryPage
import java.io.File
import java.lang.System.getProperty
import java.net.URI
import java.nio.file.Paths
import java.util.concurrent.TimeUnit
import javax.imageio.ImageIO

lateinit var driver: WebDriver
    private set

fun main(args: Array<String>) {

    setup()
    gotoUrl("https://euctis-audit.ema.europa.eu/ct-authority-services/login")

    val loginPage = LoginPage(driver)
    loginPage.login(UtilResources.getProperties("msUser"), UtilResources.getProperties("msPwd"))

    gotoUrl("https://euctis-audit.ema.europa.eu/ct-authority-services/#!/trials/2021-500523-50-00/summary")
    val summaryPage = SummaryPage(driver)
    summaryPage.clickOnInitialApplicationLink()

    val initialApplicationPage = InitialApplicationPage(driver)
    initialApplicationPage.toogleSectionTrialIdentifiers()

    //takeSceenshot(driver.findElement(By.xpath("//application[1]")), "application")

}

fun takeSceenshot(element: WebElement, fileName: String) {
    val screenshotFile = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
    val fullImg = ImageIO.read(screenshotFile)
    val point = element.location
    val elementWidth = element.size.getWidth()
    val elementHeight = element.size.getHeight()
    val eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), elementWidth, elementHeight)
    ImageIO.write(eleScreenshot, "png", screenshotFile)
    val tempDir: String = getProperty("java.io.tmpdir")
    println("Sparar $fileName.png i $tempDir")
    val destFile = File(Paths.get(tempDir, "$fileName.png").toString())
    FileUtils.copyFile(screenshotFile, destFile)
}

fun gotoUrl(url: String) {
    driver?.get(URI(url).toString())
}


fun setup() {
    System.setProperty(UtilResources.getProperties("nameDriver"),
        UtilResources.getProperties("pathDriver") + UtilResources.getProperties("exeDriver"))
    driver = ChromeDriver()
    driver?.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
    driver?.manage()?.window()?.maximize()
}