package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class InitialApplicationPage (driver: WebDriver) {

    @FindBy(xpath = ".//span[@class='pull-right ng-scope fa fa-chevron-right'][1]")  // pull-right ng-scope fa fa-chevron-right //title[@lang='en']
    private val sectionTrialIdentifiers: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun toogleSectionTrialIdentifiers() {
        sectionTrialIdentifiers?.click()
    }
}