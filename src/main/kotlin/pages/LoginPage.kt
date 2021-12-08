package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class LoginPage (driver: WebDriver) {

    @FindBy(name = "username")
    private val usernameField: WebElement? = null

    @FindBy(name = "password")
    private val pwdField: WebElement? = null

    @FindBy(name = "submit")
    private val loginButton: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun login(username: String, pwd: String) {
        usernameField?.sendKeys(username)
        pwdField?.sendKeys(pwd)
        loginButton?.click()
    }
}