import com.othr.ajp.mocker.Mocker;
import org.junit.jupiter.api.Test;

import static com.othr.ajp.mocker.Mocker.*;


import java.util.ArrayList;
import java.util.List;

public class OthMockerTest {
    @Test
    public void mockTest1() {
        List<String> mockObject = mock(ArrayList.class);
        System.out.println(mockObject == null);
        mockObject.add("Test");
        mockObject.get(0);
//        verify(mockObject).add("Test");
    }
}
