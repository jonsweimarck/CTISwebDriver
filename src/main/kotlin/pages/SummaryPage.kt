package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SummaryPage (driver: WebDriver) {

    @FindBy(xpath = ".//a[contains(.,'IN')]")
    private val InitialApplicationLink: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun clickOnInitialApplicationLink() {
        InitialApplicationLink?.click()
    }
}