
import com.mycompany.techmap.Service.DataRepository;
import com.mycompany.techmap.model.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DataRepositoryTest {

    private DataRepository repo;

    @BeforeEach
    public void setup() {
        repo = DataRepository.getInstance();
        repo.getComponents().clear();
        repo.getEquipment().clear();
    }

    @Test
    public void testAddComponentAndFind() {
        Component c = new Component("Резистор", "SMD", 10);
        repo.addComponent(c);

        Component found = repo.findComponent("Резистор", "SMD");
        assertNotNull(found);
        assertEquals(10, found.getQuantity());
    }

    @Test
    public void testAddEquipmentAndFind() {
        Equipment e = new Equipment("Паяльная станция", "Model X", 1);
        repo.addEquipment(e);

        Equipment found = repo.findEquipment("Паяльная станция", "Model X");
        assertNotNull(found);
        assertEquals(1, found.getQuantity());
    }

}
