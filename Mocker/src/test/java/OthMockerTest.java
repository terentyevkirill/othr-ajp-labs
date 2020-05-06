import org.junit.jupiter.api.Test;

import static com.othr.ajp.mocker.Mocker.*;

import java.util.ArrayList;
import java.util.List;

public class OthMockerTest {
    @Test
    public void spyTest() {
        List<String> names = new ArrayList<>();
        List<String> spyList = spy(names);

        spyList.add("John Doe"); // really adds to ArrayList names
        spyList.add("Max Muster");
        spyList.add("John Doe");
        System.out.println(spyList.size());     // would return 3
        verify(spyList, atMost(2)).add("John Doe");
        verify(spyList, atLeast(1)).add("Max Muster");
        verify(spyList, never()).clear();
        verify(spyList, times(1)).add("Max");   // result in Assertion
        verify(spyList, atLeast(1)).clear();
    }

    @Test
    public void mockTest() {
        List<String> mockObject = mock(ArrayList.class);

        mockObject.add("John Doe");
        mockObject.add("Max Muster");
        mockObject.add("John Doe");
        mockObject.size(); // would return 0 as mock’s default return value
        mockObject.clear();

        verify(mockObject, times(2)).add("John Doe");
        verify(mockObject).add("Max Muster");   // same as times(1)
        verify(mockObject, never()).clear();    // result in Assertion
    }


}
