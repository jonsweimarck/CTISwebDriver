package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SearchPage (driver: WebDriver) {

    @FindBy(name = "businessKey")
    private val ctNumberField: WebElement? = null

    @FindBy(className = "btn-primary")
    private val searchButton: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun searchOnCtNumber(ctNumber: String) {
        ctNumberField?.sendKeys(ctNumber)
        searchButton?.click()
    }
}