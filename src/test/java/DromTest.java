import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class DromTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/dubakinsergey/Downloads/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);


        //Открыть https://www.drom.ru/
        driver.get("https://www.drom.ru/");


        //Кнопка (Выбрать регион)
        WebElement buttonHomeRegionChange = driver.findElement(By.xpath("//a[@data-ga-stats-name=\"HomeRegionChange\"]"));
        buttonHomeRegionChange.click();


        //Ярославская область
        WebElement clickRegionYaroslavlOblast = driver.findElement(By.xpath("//a[@href=\"https://www.drom.ru/my_region/?set_region=76\"]"));
        clickRegionYaroslavlOblast.click();

        //Выбрать (Марка)
        WebElement brandCar = driver.findElement(By.xpath("//input[@placeholder=\"Марка\"]"));
        brandCar.click();
        brandCar.sendKeys("nissan");

        //Thread.sleep(5000) для ожидания загрузки
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Выбрать Nissan
        WebElement selectCarNissan = driver.findElement(By.xpath("(//div[@role=\"option\"])[1]"));
        selectCarNissan.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Выбрать Dayz
        WebElement selectModel = driver.findElement(By.xpath("//input[@placeholder=\"Модель\"]"));
        selectModel.click();
        selectModel.sendKeys("dayz");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement selectDayz = driver.findElement(By.xpath("(//div[@aria-label=\"Модель\"]//div[@role=\"option\"])[1]"));
        selectDayz.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Выбрать Поколение
        WebElement selectGeneration = driver.findElement(By.xpath("//div[@data-ftid=\"sales__filter_generation\"]"));
        selectGeneration.click();

        WebElement clickGeneration = driver.findElement(By.xpath("//div[@aria-label=\"1-е поколение, рестайлинг\"]"));
        clickGeneration.click();
        selectGeneration.click();

        //Выбрать Топливо(бензин)
        WebElement selectGas = driver.findElement(By.xpath("//div[@aria-label=\"Топливо\"]//button[@data-ftid=\"component_select_button\"]"));
        selectGas.click();

        WebElement selectOil = driver.findElement(By.xpath("(//div[@aria-label=\"Топливо\"]//div[@role=\"option\"])[1]"));
        selectOil.click();

        //Выбрать Привод(4WD)
        WebElement selectDriveAuto = driver.findElement(By.xpath("//div[@aria-label=\"Привод\"]"));
        selectDriveAuto.click();

        WebElement clickselectDriveAuto4Wd = driver.findElement(By.xpath("(//div[@aria-label=\"Привод\"]//div[@role=\"option\"])[1]"));
        clickselectDriveAuto4Wd.click();

        //Чекбокс кликнуть (С фото)
        WebElement checkboxWithPhoto = driver.findElement(By.xpath("//label[@for=\"photo\"]"));
        checkboxWithPhoto.click();

        //Показать
        WebElement selectButtonShow = driver.findElement(By.xpath("//button[@data-ftid=\"sales__filter_submit-button\"]"));
        selectButtonShow.click();

        //Выбрать (Все регионы)
        WebElement selectAllRegions = driver.findElement(By.xpath("//a[@data-ftid=\"sales_search-location-picker_geoAll\"]"));
        selectAllRegions.click();

        //Сортировка (С высокой ценой)
        WebElement sortPrice = driver.findElement(By.xpath("//div[@aria-label=\"Сначала показывать\"]//div//button[@data-ftid=\"component_select_button\"]"));
        sortPrice.click();

        WebElement clickHighPrice = driver.findElement(By.xpath("(//div[@aria-label=\"Сначала показывать\"]//div[@role=\"option\"])[4]"));
        clickHighPrice.click();

        // Вывести в консоль название и стоимость 3х самых дорогих авто

        List<WebElement> carList = driver.findElements(By.xpath("//a[@data-ftid=\"bulls-list_bull\"]"));

        // Вывести в консоль название и стоимость 3х самых дорогих автомобилей
        for (int i = 0; i < 3; i++) {
            WebElement car = carList.get(i);
            String name = car.findElement(By.xpath("//span[@data-ftid=\"bull_title\"]")).getText();
            String price = car.findElement(By.xpath("//span[@data-ftid=\"bull_price\"]")).getText();
            System.out.println("Автомобиль " + (i + 1));
            System.out.println("Название: " + name);
            System.out.println("Стоимость: " + price);
            System.out.println("------------");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
