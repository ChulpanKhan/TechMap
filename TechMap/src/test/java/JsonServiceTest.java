
import com.mycompany.techmap.Service.JsonService;
import com.mycompany.techmap.model.*;
import java.io.File;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class JsonServiceTest {

    private Product testProduct;
    private File tempFile;

    @BeforeEach
    public void setup() throws Exception {
        // Создаём продукт
        testProduct = new Product("TestProduct", "Микроэлектроника");

        Organization org = new Organization("TestOrg", "Москва");

        ProcessStep step = new ProcessStep("step1", "Подготовка", org);
        step.setComponents(Arrays.asList(new Component("Резистор", "SMD", 5)));
        step.setEquipment(Arrays.asList(new Equipment("Печь", "X100", 2)));
        step.setPersonnel(Arrays.asList(
                new PersonnelRequirement(new PersonnelType("Оператор"), 4)
        ));

        testProduct.getTechnologyMap().addStep(step);

        // Временный файл
        tempFile = File.createTempFile("test_product", ".json");
        tempFile.deleteOnExit();
    }

    @Test
    public void testSaveAndLoadProduct() throws Exception {
        // Сохраняем продукт
        JsonService.saveProductToFile(testProduct, tempFile);

        // Загружаем его обратно
        Product loaded = JsonService.loadProductFromFile(tempFile);

        // Проверки
        assertNotNull(loaded, "Загруженный продукт не должен быть null");
        assertEquals("TestProduct", loaded.getName());
        assertEquals("Микроэлектроника", loaded.getStrategicDirection());
        assertEquals(1, loaded.getTechnologyMap().getAllSteps().size());

        ProcessStep loadedStep = loaded.getTechnologyMap().getAllSteps().get(0);
        assertEquals("Подготовка", loadedStep.getName());
        assertEquals(1, loadedStep.getComponents().size());
        assertEquals(5, loadedStep.getComponents().get(0).getQuantity());
    }
}
