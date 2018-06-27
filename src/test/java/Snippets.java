import org.junit.Test;
//import org.openqa.selenium.interactions.Actions;

public class Snippets {
    private By popUpOk = By.xpath("//table//button[text()='OK']");

    @Test
    public void clickWithActions(){
        WebElement isPopUp = waitForElement(this.popUpOk);
                WebElement secondPopUp = waitForElement(this.popUpOk);
                Actions actions = new Actions(driver);
                if (isPopUp  != null && isPopUp.isDisplayed()) {
                        actions.moveToElement(isPopUp).click().perform();
                    }
                Thread.sleep(500);
                if (secondPopUp  != null && isPopUp.isDisplayed()) {
                        actions.moveToElement(secondPopUp).click().perform();

    }

    public static void main(String[] args) {

        try{

        }

    }




}
