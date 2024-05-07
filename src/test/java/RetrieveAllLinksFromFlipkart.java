import com.GenericUtility.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;

@Listeners(com.GenericUtility.ListenerImplementationClass.class)
public class RetrieveAllLinksFromFlipkart  extends BaseClass {

    @Test
    public void usingForEachLoop() {
        List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
        for (WebElement link : allLinks) {
            Reporter.log(link.getAttribute("href"));
        }
    }

    @Test
    public void usingSteamConcept() {
        List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
        List<String> links = allLinks.stream()
                .map(element -> element.getAttribute("href"))
                .filter(href -> href != null && !href.isEmpty())
                .collect(Collectors.toList());
        links.forEach(link -> System.out.println(link));
    }

    @Test
    public void usingParallelSteamConcept() {
        List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
        List<String> links = allLinks.parallelStream()
                .map(element -> element.getAttribute("href"))
                .filter(href -> href != null && !href.isEmpty())
                .collect(Collectors.toList());
        links.forEach(System.out::println);
    }
}
